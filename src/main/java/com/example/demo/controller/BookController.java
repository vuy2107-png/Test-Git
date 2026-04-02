package com.example.demo.controller;

import com.example.demo.DTO.BookCreateRequest;
import com.example.demo.DTO.BookResponse;
import com.example.demo.DTO.BookUpdateRequest;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 1. GET ALL
    @GetMapping
    public List<BookResponse> getAll() {
        return bookService.getAll();
    }

    // 2. GET BY ID
    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    // 3. SEARCH
    @GetMapping("/search")
    public List<BookResponse> search(@RequestParam String title) {
        return bookService.search(title);
    }

    // 4. CREATE
    @PostMapping
    public BookResponse create(@Valid @RequestBody BookCreateRequest request) {
        return bookService.create(request);
    }

    // 5. UPDATE
    @PutMapping("/{id}")
    public BookResponse update(
            @PathVariable Long id,
            @Valid @RequestBody BookUpdateRequest request
    ) {
        return bookService.update(id, request);
    }

    // 6. DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
