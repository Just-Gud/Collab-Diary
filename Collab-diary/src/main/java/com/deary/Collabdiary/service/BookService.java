package com.deary.Collabdiary.service;

import com.deary.Collabdiary.entity.Book;

import java.util.List;

public interface BookService {
    public Book saveBook(Book book);

    public List<Book> getBooksList();

    public Book getBookById(Long bookId);

    public void deleteBookById(Long bookId);

    public Book updateBookById(Long bookId, Book book);
}
