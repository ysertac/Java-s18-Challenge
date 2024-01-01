package com.workintech.service;

import com.workintech.entity.Book;
import com.workintech.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        throw new RuntimeException("Book not found with this id.");
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
