package ru.nonoka.servicefactorial.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nonoka.servicefactorial.dto.JsonResponse;
import ru.nonoka.servicefactorial.model.JsonRequest;
import ru.nonoka.servicefactorial.service.FactorialService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calc")
public class FactorialController {

    private final FactorialService factorialService;

    @PostMapping
    public ResponseEntity<JsonResponse> calculate(@Validated @RequestBody JsonRequest factorial) {
        return ResponseEntity.ok(factorialService.calculate(factorial));
    }
}
