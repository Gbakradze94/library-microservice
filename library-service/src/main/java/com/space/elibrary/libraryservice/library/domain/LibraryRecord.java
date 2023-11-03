package com.space.elibrary.libraryservice.library.domain;

import lombok.Builder;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

@Builder
public record LibraryRecord(
        @Id
        String recordId,
        String title,
        @AccessType(AccessType.Type.PROPERTY)
        String author,
        String format
) implements Persistable<String> {
        @Override
        public String getId() {
                return recordId;
        }

        @Override
        public boolean isNew() {
                return true;
        }
}
