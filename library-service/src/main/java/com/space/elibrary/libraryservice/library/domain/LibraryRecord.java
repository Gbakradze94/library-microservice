package com.space.elibrary.libraryservice.library.domain;

import lombok.Builder;

@Builder
public record LibraryRecord(

        String recordId,
        String title,
        String author,
        String format
) {
}
