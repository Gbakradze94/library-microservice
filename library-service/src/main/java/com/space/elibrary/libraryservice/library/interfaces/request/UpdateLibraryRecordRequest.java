package com.space.elibrary.libraryservice.library.interfaces.request;

import lombok.Builder;

@Builder
public record UpdateLibraryRecordRequest(
        String recordId,
        String title,
        String author,
        String format
) {
}
