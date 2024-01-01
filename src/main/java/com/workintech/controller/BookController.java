package com.workintech.controller;

import com.workintech.dto.AuthorResponse;
import com.workintech.dto.BookResponse;
import com.workintech.entity.Author;
import com.workintech.entity.Book;
import com.workintech.entity.Category;
import com.workintech.service.AuthorService;
import com.workintech.service.BookService;
import com.workintech.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @PostMapping("/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable long categoryId) {
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName(), null);
    }

    @PostMapping("/savebyauthor")
    public BookResponse save(@RequestBody Book book, @RequestParam long categoryId, @RequestParam long authorId) {
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        Author author = authorService.findById(authorId);
        book.setAuthor(author);
        author.addBook(book);
        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName(),
                new AuthorResponse(author.getId(), author.getFirstName() + " " + author.getLastName()));
    }
}
