package com.space.elibrary.libraryservice.library.service;

import com.space.elibrary.libraryservice.library.domain.LibraryRecord;
import com.space.elibrary.libraryservice.library.interfaces.request.CreateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.request.LibraryRecordCreatedResponse;
import com.space.elibrary.libraryservice.library.interfaces.request.UpdateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordListResponse;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import com.space.elibrary.libraryservice.library.mapper.LibraryRecordMapper;
import com.space.elibrary.libraryservice.library.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final LibraryRecordMapper libraryRecordMapper;

    public Mono<LibraryRecordListResponse> fetchLibraryRecords() {
        return libraryRepository.findAll()
                .collectList()
                .map(libraryRecordsList -> libraryRecordsList.stream()
                        .map(libraryRecordMapper::mapLibraryRecordEntityToResponse)
                        .toList()
                )
                .map(libraryRecordResponse -> LibraryRecordListResponse.builder()
                        .libraryRecordResponseList(libraryRecordResponse)
                                .build()
                );
    }

    public Mono<LibraryRecordResponse> fetchLibraryRecordById(String recordId) {
        return libraryRepository.findById(recordId)
                .map(libraryRecordMapper::mapLibraryRecordEntityToResponse);
    }

    public Mono<Void> deleteLibraryRecord(String recordId) {
        return libraryRepository.deleteById(recordId);
    }

    public Mono<LibraryRecordCreatedResponse> createLibraryRecord(CreateLibraryRecordRequest createRecordRequest) {
        LibraryRecord libraryRecord =
                libraryRecordMapper.mapRecordRequestToLibraryRecord(createRecordRequest);
        return libraryRepository.save(libraryRecord)
                .map(savedLibraryRecord -> LibraryRecordCreatedResponse.builder()
                        .recordId(libraryRecord.recordId())
                        .build()
                );
    }

    public Mono<Void> updateLibraryRecord(String recordId, UpdateLibraryRecordRequest updateRequest) {
        return libraryRepository.findById(recordId)
                .flatMap(libraryRecordResponse -> libraryRepository
                        .save(libraryRecordMapper.mapRequestToLibraryRecord(updateRequest)))
                .flatMap(response -> Mono.empty());
    }
}
