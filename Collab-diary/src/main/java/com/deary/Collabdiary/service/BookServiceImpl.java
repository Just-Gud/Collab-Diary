package com.deary.Collabdiary.service;

import com.deary.Collabdiary.entity.Book;
import com.deary.Collabdiary.error.BookNotFoundException;
import com.deary.Collabdiary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksList() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) throws BookNotFoundException {
        Optional<Book> book = bookRepository.findById(bookId);
        if(!book.isPresent())
            throw new BookNotFoundException("Book not found for this id :: " + bookId);
        return book.get();
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book updateBookById(Long bookId, Book book) {
        Book existingBook = bookRepository.findById(bookId).get();
        existingBook.setName(book.getName());
        existingBook.setDescription(book.getDescription());
        return bookRepository.save(existingBook);
    }
}
