package com.space.elibrary.libraryservice.library.mapper;

import com.space.elibrary.libraryservice.library.domain.LibraryRecord;
import com.space.elibrary.libraryservice.library.interfaces.request.CreateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.request.UpdateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LibraryRecordMapper {
    @Mapping(target = "recordId", source = "recordId")
    LibraryRecordResponse libraryRecordEntityToResponse(LibraryRecord libraryRecord);

    @Mapping(target = "recordId", source = "recordId")
    LibraryRecord mapRecordRequestToLibraryRecord(CreateLibraryRecordRequest libraryRecord);

    @Mapping(target = "recordId", source = "recordId")
    @Mapping(target = "format", source = "format")
    LibraryRecord mapRequestToLibraryRecord(UpdateLibraryRecordRequest updateLibraryRecordRequest);
}
