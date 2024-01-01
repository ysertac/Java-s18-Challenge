package com.workintech.dto;

public record BookResponse(long id, String name, String categoryName, AuthorResponse authorResponse) {
}
