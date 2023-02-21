package com.deary.Collabdiary.service;

import com.deary.Collabdiary.entity.Book;
import com.deary.Collabdiary.error.BookNotFoundException;
import com.deary.Collabdiary.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        Book book1 = Book.builder()
                .bookId(1L)
                .description("Description1")
                .name("Book1")
                .build();
        Mockito.when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(book1));
        Book book2 = Book.builder()
                .bookId(2L)
                .description("Description2")
                .name("Book2")
                .build();

    }

    @Test
    @DisplayName("Test getBookById() method")
//    @Disabled
    public void whenValidId_thenBookShouldBeFound() throws BookNotFoundException {
        Long bookId = 1L;
        String expectedName = "Book1";
        String actualName = bookService.getBookById(bookId).getName();
        assertEquals(expectedName, actualName);
    }
}