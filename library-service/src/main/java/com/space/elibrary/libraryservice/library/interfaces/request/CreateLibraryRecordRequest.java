package com.space.elibrary.libraryservice.library.interfaces.request;

import lombok.Builder;

@Builder
public record CreateLibraryRecordRequest(
        String recordId,
        String title,
        String author,
        String format
) {
}
