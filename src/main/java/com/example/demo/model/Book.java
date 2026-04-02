package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title không được để trống")
    @Size(max = 255)
    @Column(nullable = false)
    private String title;

    @Size(max = 255)
    private String author;

    @NotBlank(message = "ISBN không được để trống")
    @Size(max = 20)
    @Column(nullable = false, unique = true)
    private String isbn;

    @Min(value = 0, message = "Năm xuất bản phải >= 0")
    private Integer publishedYear;

    @DecimalMin(value = "0.0", message = "Giá phải >= 0")
    private Double price;

    @Min(value = 0, message = "Số lượng phải >= 0")
    private Integer quantity;
}
