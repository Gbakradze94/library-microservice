package com.space.elibrary.libraryservice.library.service;

import com.space.elibrary.libraryservice.library.domain.LibraryRecord;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import com.space.elibrary.libraryservice.library.mapper.LibraryRecordMapper;
import com.space.elibrary.libraryservice.library.repository.LibraryRepository;
import com.space.elibrary.libraryservice.library.util.LibraryTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static com.space.elibrary.libraryservice.library.util.LibraryTestUtils.RECORD_ID;
import static com.space.elibrary.libraryservice.library.util.LibraryTestUtils.buildLibraryRecord;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    private LibraryRepository libraryRepository;

    @Mock
    private LibraryRecordMapper libraryRecordMapper;

    @InjectMocks
    private LibraryService libraryService;

    @Test
    void whenFetchLibraryRecords_shouldReturnLibraryRecordListResponse() {
        when(libraryRecordMapper.libraryRecordEntityToResponse(any()))
                .thenReturn(LibraryTestUtils.buildLibraryRecordResponse());

        when(libraryRepository.findAll())
                .thenReturn(LibraryTestUtils.buildFluxOfLibraryRecordList());

        StepVerifier.create(libraryService.fetchLibraryRecords())
                .assertNext(libraryRecordListResponse -> {
                    List<LibraryRecordResponse> libraryRecordResponses = libraryRecordListResponse
                            .getLibraryRecordResponseList();
                    assertThat(libraryRecordResponses.get(0).recordId())
                            .isEqualTo(RECORD_ID);
                })
                .verifyComplete();

        verify(libraryRepository).findAll();
        verifyNoMoreInteractions(libraryRepository);
    }

    @Test
    void whenFetchLibraryRecordById_shouldReturnLibraryRecordResponse() {
        when(libraryRecordMapper.libraryRecordEntityToResponse(any()))
                .thenReturn(LibraryTestUtils.buildLibraryRecordResponse());

        when(libraryRepository.findById(anyString()))
                .thenReturn(Mono.just(LibraryTestUtils.buildLibraryRecord()));

        StepVerifier.create(libraryService.fetchLibraryRecordById(RECORD_ID))
                .assertNext(libraryRecordResponse -> {
                    assertThat(libraryRecordResponse.recordId().equals(RECORD_ID));
                })
                .verifyComplete();

        verify(libraryRepository).findById(RECORD_ID);
        verifyNoMoreInteractions(libraryRepository);
    }
    @Test
    void whenCreateLibraryRecord_shouldReturnLibraryRecordResponse() {
        when(libraryRecordMapper.mapRecordRequestToLibraryRecord(any()))
                .thenReturn(LibraryTestUtils.buildLibraryRecord());

        when(libraryRepository.save(any()))
                .thenReturn(Mono.just(LibraryTestUtils.buildLibraryRecord()));

        StepVerifier.create(libraryService.createLibraryRecord(LibraryTestUtils.buildCreateLibraryRecordRequest()))
                .assertNext(libraryRecordResponse -> {
                    assertThat(libraryRecordResponse.recordId().equals(RECORD_ID));
                })
                .verifyComplete();

        verify(libraryRepository).save(buildLibraryRecord());
        verifyNoMoreInteractions(libraryRepository);
    }
}
