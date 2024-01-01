package com.workintech.service;

import com.workintech.entity.Book;

public interface BookService {

    Book findById(long id);

    Book save(Book book);

}
