package com.space.elibrary.libraryservice.library.controller;

import com.space.elibrary.libraryservice.library.LibraryApi;
import com.space.elibrary.libraryservice.library.interfaces.request.CreateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.request.UpdateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordListResponse;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import com.space.elibrary.libraryservice.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public Mono<ResponseEntity<LibraryRecordResponse>> fetchLibraryRecordById(String recordId) {
        return libraryService.fetchLibraryRecordById(recordId)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<LibraryRecordResponse>> createLibraryRecord(CreateLibraryRecordRequest createRecordRequest) {
        return libraryService.createLibraryRecord(createRecordRequest)
                .map(response -> new ResponseEntity<>(response, HttpStatus.CREATED));
    }

    @Override
    public Mono<Void> updateLibraryRecord(String recordId, UpdateLibraryRecordRequest updateLibraryRecordRequest) {
       return libraryService.updateLibraryRecord(recordId, updateLibraryRecordRequest);
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteLibraryRecord(String recordId) {
        return libraryService.deleteLibraryRecord(recordId)
                .map(response -> new ResponseEntity<>(response, HttpStatus.NO_CONTENT));
    }
}
