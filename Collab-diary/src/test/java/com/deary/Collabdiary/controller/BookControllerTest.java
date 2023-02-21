package com.deary.Collabdiary.controller;

import com.deary.Collabdiary.entity.Book;
import com.deary.Collabdiary.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        book = Book.builder()
                .name("Book1")
                .description("Book1 Description")
                .build();
    }

    @Test
    void saveBook() throws Exception {
        Book inputBook = Book.builder()
                .name("Book2")
                .description("Book1 Description")
                .build();

        Mockito.when(bookService.saveBook(inputBook)).thenReturn(book);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"Book21\",\n" +
                        "    \"description\": \"Book1 Description\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getBookById() {
    }
}