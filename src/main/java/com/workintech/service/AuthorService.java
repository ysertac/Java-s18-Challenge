package com.workintech.service;

import com.workintech.entity.Author;

public interface AuthorService {

    Author findById(long id);

    Author save(Author author);
}
