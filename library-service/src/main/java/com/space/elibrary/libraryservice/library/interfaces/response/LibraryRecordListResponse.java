package com.space.elibrary.libraryservice.library.interfaces.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryRecordListResponse {
    List<LibraryRecordResponse> libraryRecordResponseList;
}
