package com.example.demo.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateRequest {
    @NotBlank(message = "Title không được để trống")
    private String title;

    private String author;

    @NotBlank(message = "ISBN không được để trống")
    private String isbn;

    @Min(0)
    private Integer publishedYear;

    @DecimalMin(value = "0.0")
    private Double price;

    @Min(0)
    private Integer quantity;
}
