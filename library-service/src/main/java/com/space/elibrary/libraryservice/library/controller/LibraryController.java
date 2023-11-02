package com.space.elibrary.libraryservice.library.controller;

import com.space.elibrary.libraryservice.library.interfaces.request.CreateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.response.CreateLibraryRecordResponse;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordListResponse;
import com.space.elibrary.libraryservice.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LibraryController implements LibraryApi {

    private final LibraryService libraryService;

    @Override
    public Mono<ResponseEntity<LibraryRecordListResponse>> fetchLibraryRecords() {
        return libraryService.fetchLibraryRecords()
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<LibraryRecordListResponse>> fetchLibraryRecordById(String recordId) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<CreateLibraryRecordResponse>> createLibraryRecord(CreateLibraryRecordRequest createRecordRequest) {
        return null;
    }

    @Override
    public Mono<Void> updateLibraryRecord(String recordId) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteLibraryRecord(String recordId) {
        return null;
    }
}
