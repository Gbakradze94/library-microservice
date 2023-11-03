package com.space.elibrary.libraryservice.library.controller;

import com.space.elibrary.libraryservice.library.interfaces.request.CreateLibraryRecordRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Arrays;

import static com.space.elibrary.libraryservice.library.util.LibraryTestUtils.AUTHOR;
import static com.space.elibrary.libraryservice.library.util.LibraryTestUtils.FORMAT;
import static com.space.elibrary.libraryservice.library.util.LibraryTestUtils.RECORD_ID;
import static com.space.elibrary.libraryservice.library.util.LibraryTestUtils.TITLE;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LibraryControllerIT {

    @Autowired
    private WebTestClient webTestClient;


    @Order(1)
    @Test
    void testFetchLibraryRecords() {

        webTestClient.get()
                .uri("/profile/library-records")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody();
    }

    @Order(2)
    @Test
    void testCreateLibraryRecord() {

        var createLibraryRecordRequest = CreateLibraryRecordRequest.builder()
                .recordId(RECORD_ID)
                .author(AUTHOR)
                .title(TITLE)
                .format(FORMAT)
                .build();


        webTestClient.post()
                .uri("/profile/library-records")
                .body(BodyInserters.fromValue(createLibraryRecordRequest))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isCreated();
    }

    @Order(3)
    @Test
    void testFetchLibraryRecordById() {

        webTestClient.get()
                .uri("/profile/library-records/{id}", RECORD_ID)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.recordId").isEqualTo(RECORD_ID);
    }

    @Order(4)
    @Test
    void testDeleteLibraryRecordById() {

        webTestClient.delete()
                .uri("/profile/library-records/{id}", RECORD_ID)
                .exchange()
                .expectStatus()
                .isOk();
    }
}
