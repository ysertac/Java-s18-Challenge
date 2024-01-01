package com.workintech.service;

import com.workintech.entity.Author;
import com.workintech.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            return authorOptional.get();
        }
        throw new RuntimeException("Author not found with this id.");
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
