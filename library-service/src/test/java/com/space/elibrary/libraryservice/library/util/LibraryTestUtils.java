package com.space.elibrary.libraryservice.library.util;

import com.space.elibrary.libraryservice.library.domain.LibraryRecord;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordListResponse;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Flux;

import java.util.List;

@UtilityClass
public class LibraryTestUtils {
    public static final String RECORD_ID = "1234567890";
    private static final String FORMAT = "Hardcover";
    private static final String TITLE = "The Shining";
    private static final String AUTHOR = "Stephen King";


    public static LibraryRecordListResponse buildLibraryRecordListResponse() {
        return LibraryRecordListResponse.builder()
                .libraryRecordResponseList(buildLibraryRecordResponseList())
                .build();
    }

    private List<LibraryRecordResponse> buildLibraryRecordResponseList() {
        return List.of(
                buildLibraryRecordResponse()
        );
    }

    public LibraryRecordResponse buildLibraryRecordResponse() {
        return LibraryRecordResponse.builder()
                .recordId(RECORD_ID)
                .title(TITLE)
                .author(AUTHOR)
                .format(FORMAT)
                .build();
    }

    public Flux<LibraryRecord> buildFluxOfLibraryRecordList() {
        return Flux.fromIterable(List.of(buildLibraryRecord()));
    }

    private static LibraryRecord buildLibraryRecord() {
        return LibraryRecord.builder()
                .recordId(RECORD_ID)
                .author(AUTHOR)
                .title(TITLE)
                .format(FORMAT)
                .build();
    }
}
