package com.space.elibrary.libraryservice.library.service;

import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import com.space.elibrary.libraryservice.library.mapper.LibraryRecordMapper;
import com.space.elibrary.libraryservice.library.repository.LibraryRepository;
import com.space.elibrary.libraryservice.library.util.LibraryTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import java.util.List;

import static com.space.elibrary.libraryservice.library.util.LibraryTestUtils.RECORD_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
}
