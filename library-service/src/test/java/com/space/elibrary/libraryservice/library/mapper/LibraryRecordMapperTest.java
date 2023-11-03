package com.space.elibrary.libraryservice.library.mapper;

import com.space.elibrary.libraryservice.library.util.LibraryTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class LibraryRecordMapperTest {
    private final LibraryRecordMapper mapper = Mappers.getMapper(LibraryRecordMapper.class);

    @Test
    void shouldMapLibraryRecordEntityToResponse() {
        final var actual = mapper
                .mapLibraryRecordEntityToResponse(LibraryTestUtils.buildLibraryRecord());

        final var expected = LibraryTestUtils.buildLibraryRecordResponse();

        assertEquals(expected, actual);
    }

    @Test
    void shouldMapRecordRequestToLibraryRecord() {
        final var actual = mapper
                .mapRecordRequestToLibraryRecord(LibraryTestUtils.buildCreateLibraryRecordRequest());

        final var expected = LibraryTestUtils.buildLibraryRecord();

        assertEquals(expected, actual);
    }

    @Test
    void shouldMapRequestToLibraryRecord() {
        final var actual = mapper
                .mapRequestToLibraryRecord(LibraryTestUtils.buildUpdateLibraryRequest());

        final var expected = LibraryTestUtils.buildLibraryRecord();

        assertEquals(expected, actual);
    }
}
