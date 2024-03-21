package ru.nonoka.servicefactorial.service.impl;

import org.junit.jupiter.api.Test;
import ru.nonoka.servicefactorial.dto.JsonResponse;
import ru.nonoka.servicefactorial.model.JsonRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialServiceImplTest {

    private final FactorialServiceImpl service = new FactorialServiceImpl();

    @Test
    void calcCorrectResultIfValidInputParameter() {
        long input = 5;
        long expected = 120;
        long actualResult = service.calc(input);
        assertEquals(expected, actualResult);
    }

    @Test
    void calculateCorrectReturnJsonResponse() {
        JsonRequest request = new JsonRequest(1L);
        JsonResponse jsonResponseExpected = new JsonResponse(1L);

        JsonResponse jsonResponseActual = service.calculate(request);
        assertEquals(jsonResponseExpected, jsonResponseActual);
    }

    @Test
    void calculateNoCorrectResultParameterIsNull() {
        JsonRequest request = new JsonRequest(null);

        assertThrows(NullPointerException.class, () -> service.calculate(request));
    }

    @Test
    void calculateNoCorrectResultParameterInvalid() {
        JsonRequest invalidJson1 = new JsonRequest(-120L);
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculate(invalidJson1);
        });

        JsonRequest invalidJson2 = new JsonRequest(40L);
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculate(invalidJson2);
        });
    }
}