package com.space.elibrary.libraryservice.library.mapper;

import com.space.elibrary.libraryservice.library.domain.LibraryRecord;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LibraryRecordMapper {
    @Mapping(target = "recordId", source = "recordId")
    LibraryRecordResponse libraryRecordEntityToResponse(LibraryRecord libraryRecord);
}
