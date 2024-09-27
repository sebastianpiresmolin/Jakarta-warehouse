package com.streams.entities;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

public record Product(
        @Min(1) int id,

        @NotNull
        @Size(min = 1, max = 100) String name,

        @NotNull Category category,

        @Min(0)
        @Max(10) int rating,

        @PastOrPresent LocalDate createdDate,

        @PastOrPresent LocalDate lastModifiedDate
) {}