package com.workintech.dto;

import com.workintech.entity.Book;

import java.util.List;

public record AuthorResponseWithBooks(List<BookResponse> responseList) {
}
