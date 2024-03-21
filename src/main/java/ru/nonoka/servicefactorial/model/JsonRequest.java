package ru.nonoka.servicefactorial.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record JsonRequest(
        @NotNull(message = "Title must be not null")
        @Max(value = 39)
        @Min(value = 0)
        @JsonSetter("factorial_num")
        Long factorialNum
) {
}
