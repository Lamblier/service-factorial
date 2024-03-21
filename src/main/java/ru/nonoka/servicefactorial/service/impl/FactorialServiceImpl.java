package ru.nonoka.servicefactorial.service.impl;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nonoka.servicefactorial.dto.JsonResponse;
import ru.nonoka.servicefactorial.model.JsonRequest;
import ru.nonoka.servicefactorial.service.FactorialService;

@Service
@RequiredArgsConstructor
public class FactorialServiceImpl implements FactorialService {

    @Timed("calculateMetrik")
    @Override
    public JsonResponse calculate(JsonRequest factorial) {
        if (factorial.factorialNum() < 0 || factorial.factorialNum() > 39) {
            throw new IllegalArgumentException("Input parameter must be between 0 and 39");
        }
        return new JsonResponse(calc(factorial.factorialNum()));
    }

    public long calc(long n) {
        if (n <= 1)
            return 1;
        else
            return n * calc(n - 1);
    }
}
