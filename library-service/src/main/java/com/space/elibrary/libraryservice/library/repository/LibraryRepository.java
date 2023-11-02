package com.space.elibrary.libraryservice.library.repository;


import com.space.elibrary.libraryservice.library.domain.LibraryRecord;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends R2dbcRepository<LibraryRecord, String> {
}
