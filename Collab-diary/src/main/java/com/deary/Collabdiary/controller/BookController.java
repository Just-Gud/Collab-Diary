package com.deary.Collabdiary.controller;

import com.deary.Collabdiary.entity.Book;
import com.deary.Collabdiary.error.BookNotFoundException;
import com.deary.Collabdiary.service.BookService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return  bookService.saveBook(book);
    }
    @GetMapping("/books")
    public List<Book> getBooksList(){
        return bookService.getBooksList();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long bookId) throws BookNotFoundException {
        LOGGER.info("Book id is: " + bookId);
        return  bookService.getBookById(bookId);
    }
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Long bookId)
    {
        bookService.deleteBookById(bookId);
        return "Book deleted";
    }

    @PutMapping("/books/{id}")
    public Book updateBookById(@PathVariable("id") Long bookId, @RequestBody Book book){
        return bookService.updateBookById(bookId, book);
    }
}
