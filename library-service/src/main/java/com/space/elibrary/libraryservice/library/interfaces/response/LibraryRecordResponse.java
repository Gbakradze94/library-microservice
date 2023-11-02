package com.space.elibrary.libraryservice.library.interfaces.response;

import lombok.Builder;

@Builder
public record LibraryRecordResponse(
        String recordId,
        String title,
        String author,
        String format
) {
}
