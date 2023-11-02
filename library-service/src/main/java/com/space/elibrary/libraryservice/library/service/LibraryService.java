package com.space.elibrary.libraryservice.library.service;

import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordListResponse;
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
                        .map(libraryRecordMapper::libraryRecordEntityToResponse)
                        .toList()
                )
                .map(libraryRecordResponse -> LibraryRecordListResponse.builder()
                        .libraryRecordResponseList(libraryRecordResponse)
                                .build()
                );
    }
}
