package com.example.demo.service;


import com.example.demo.DTO.BookCreateRequest;
import com.example.demo.DTO.BookResponse;
import com.example.demo.DTO.BookUpdateRequest;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // CREATE
    @Override
    public BookResponse create(BookCreateRequest request) {

        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .publishedYear(request.getPublishedYear())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        book = bookRepository.save(book);

        return mapToResponse(book);
    }

    // GET ALL
    @Override
    public List<BookResponse> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // GET BY ID
    @Override
    public BookResponse getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return mapToResponse(book);
    }

    // SEARCH
    @Override
    public List<BookResponse> search(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // UPDATE (chỉ update price + quantity)
    @Override
    public BookResponse update(Long id, BookUpdateRequest request) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (request.getPrice() != null) {
            book.setPrice(request.getPrice());
        }

        if (request.getQuantity() != null) {
            book.setQuantity(request.getQuantity());
        }

        book = bookRepository.save(book);

        return mapToResponse(book);
    }

    // DELETE
    @Override
    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }

    // 🔥 PRIVATE METHOD thay cho Mapper
    private BookResponse mapToResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publishedYear(book.getPublishedYear())
                .price(book.getPrice())
                .quantity(book.getQuantity())
                .build();
    }
}