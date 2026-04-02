package com.example.demo.service;

import com.example.demo.DTO.BookCreateRequest;
import com.example.demo.DTO.BookResponse;
import com.example.demo.DTO.BookUpdateRequest;

import java.util.List;

public interface BookService {
    BookResponse create(BookCreateRequest request);

    List<BookResponse> getAll();

    BookResponse getById(Long id);

    List<BookResponse> search(String title);

    BookResponse update(Long id, BookUpdateRequest request);

    void delete(Long id);
}
