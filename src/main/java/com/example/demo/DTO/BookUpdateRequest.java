package com.example.demo.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateRequest {
    @DecimalMin(value = "0.0", message = "Price phải >= 0")
    private Double price;

    @Min(value = 0, message = "Quantity phải >= 0")
    private Integer quantity;
}
