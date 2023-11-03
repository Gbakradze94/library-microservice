package com.space.elibrary.libraryservice.library.interfaces.request;

import lombok.Builder;

@Builder
public record LibraryRecordCreatedResponse(String recordId) {
}
