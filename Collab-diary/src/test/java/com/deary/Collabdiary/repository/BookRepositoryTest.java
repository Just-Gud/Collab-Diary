package com.deary.Collabdiary.repository;

import com.deary.Collabdiary.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Book book1 = Book.builder()
                .name("Book1")
                .description("Book1 Description")
                .build();

        entityManager.persist(book1);
    }

    @Test
    public void whenFindByName_thenReturnBook() {
        // given
        String name = "Book1";

        // when
        Book found = bookRepository.findBookByName(name);

        // then
        assertEquals(found.getName(), name);
    }

}