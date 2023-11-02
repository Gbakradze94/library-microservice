package com.space.elibrary.libraryservice.library.controller;

import com.space.elibrary.libraryservice.library.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static com.space.elibrary.libraryservice.library.util.LibraryTestUtils.buildLibraryRecordListResponse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibraryControllerTest {

    @Mock
    LibraryService libraryService;

    @InjectMocks
    LibraryController libraryController;

    @Test
    void whenFetchLibraryRecords_shouldReturnLibraryRecordsResponse() {
        when(libraryService.fetchLibraryRecords())
                .thenReturn(Mono.just(buildLibraryRecordListResponse()));

        StepVerifier.create(libraryController.fetchLibraryRecords())
                .assertNext(libraryRecordsResponse -> {
                    assertNotNull(libraryRecordsResponse.getBody());
                    assertNotNull(libraryRecordsResponse.getBody().getLibraryRecordResponseList());
                })
                .verifyComplete();

        verify(libraryService).fetchLibraryRecords();
        verifyNoMoreInteractions(libraryService);
    }
}
