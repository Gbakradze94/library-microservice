package com.space.elibrary.libraryservice.library.controller;

import com.space.elibrary.libraryservice.library.interfaces.request.CreateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.response.CreateLibraryRecordResponse;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordListResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

@RequestMapping("/profile")
@Tag(name = "Library API", description = "Actions that allow users to manage libraries")
public interface LibraryApi {
    @Operation(
            summary = "GET all library records"
    )
    @GetMapping("/library-records")
    Mono<ResponseEntity<LibraryRecordListResponse>> fetchLibraryRecords();

    @Operation(
            summary = "GET library record by id"
    )
    @GetMapping("/library-records/{id}")
    Mono<ResponseEntity<LibraryRecordListResponse>> fetchLibraryRecordById(@PathVariable(name = "id") String recordId);

    @PostMapping("/library-records")
    Mono<ResponseEntity<CreateLibraryRecordResponse>> createLibraryRecord(
            @Valid @RequestBody CreateLibraryRecordRequest createRecordRequest
    );

    @PutMapping("/library-records/{id}")
    Mono<Void> updateLibraryRecord(@PathVariable(name = "id") String recordId);

    @DeleteMapping("/library-records/{id}")
    Mono<ResponseEntity<Void>> deleteLibraryRecord(@PathVariable(name = "id") String recordId);
}
