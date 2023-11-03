package com.space.elibrary.libraryservice.library;

import com.space.elibrary.libraryservice.library.interfaces.request.CreateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.request.LibraryRecordCreatedResponse;
import com.space.elibrary.libraryservice.library.interfaces.request.UpdateLibraryRecordRequest;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordListResponse;
import com.space.elibrary.libraryservice.library.interfaces.response.LibraryRecordResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;
import jakarta.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/profile")
@Tag(name = "Library API", description = "Actions that allow users to manage libraries")
public interface LibraryApi {
    @Operation(
            summary = "GET all library records",
            description = "GET request to retrieve all library records",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Successful operation",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = LibraryRecordListResponse.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "There is an error in input parameters",
                            content = @Content),
                    @ApiResponse(responseCode = "500",
                            description = "Unhandled exception occurred during request processing",
                            content = @Content)
            }
    )
    @GetMapping("/library-records")
    Mono<ResponseEntity<LibraryRecordListResponse>> fetchLibraryRecords();

    @Operation(
            summary = "GET library record by id",
            description = "GET request to retrieve a library record by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "Successful operation",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = LibraryRecordListResponse.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "There is an error in input parameters",
                            content = @Content),
                    @ApiResponse(responseCode = "500",
                            description = "Unhandled exception occurred during request processing",
                            content = @Content)
            }
    )
    @GetMapping("/library-records/{id}")
    Mono<ResponseEntity<LibraryRecordResponse>> fetchLibraryRecordById(@PathVariable(name = "id") String recordId);


    @Operation(
            summary = "Create new library record",
            description = "A POST request to create new library record"
    )
    @PostMapping("/library-records")
    Mono<ResponseEntity<LibraryRecordCreatedResponse>> createLibraryRecord(
            @Valid @RequestBody CreateLibraryRecordRequest createRecordRequest
    );

    @Operation(
            summary = "Update library record",
            description = "A PUT request to update library record",
            parameters = {
                @Parameter(in = ParameterIn.PATH, name = "id", schema = @Schema(type = "string"),
                        required = true, description = "The unique record identifier",
                        example = "1234567890")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation",
                            content = @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = LibraryRecordResponse.class))),
                    @ApiResponse(responseCode = "400", description = "There is an error in input parameters",
                            content = @Content),
                    @ApiResponse(responseCode = "404", description = "Library Record not found",
                            content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "none"))
            }
    )
    @PutMapping("/library-records/{id}")
    Mono<Void> updateLibraryRecord(@PathVariable(name = "id") String recordId,
                                   @RequestBody UpdateLibraryRecordRequest updateLibraryRecordRequest
    );

    @Operation(
            summary = "Delete library record",
            description = "A DELETE request to delete new library record",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Successful operation"),
                    @ApiResponse(responseCode = "400", description = "There is an error in input parameters",
                            content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "none"))
            }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/library-records/{id}")
    Mono<ResponseEntity<Void>> deleteLibraryRecord(@PathVariable(name = "id") String recordId);
}
