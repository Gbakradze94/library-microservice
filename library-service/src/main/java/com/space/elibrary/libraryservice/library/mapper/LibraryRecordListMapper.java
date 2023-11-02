package com.space.elibrary.libraryservice.library.mapper;


import com.space.elibrary.libraryservice.library.domain.LibraryRecord;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LibraryRecordListMapper {

    List<LibraryRecordResponse> mapLibraryRecordsToResponseEntityList(List<LibraryRecord> libraryRecords);

    default LibraryRecordResponse map(LibraryRecord libraryRecord) {
       return LibraryRecordResponse.builder()
                .recordId(libraryRecord.recordId())
                .author(libraryRecord.author())
                .title(libraryRecord.title())
                .format(libraryRecord.format())
                .build();
    }
}
