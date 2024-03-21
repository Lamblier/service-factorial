package ru.nonoka.servicefactorial.service;

import ru.nonoka.servicefactorial.dto.JsonResponse;
import ru.nonoka.servicefactorial.model.JsonRequest;

public interface FactorialService {

    JsonResponse calculate(JsonRequest factorial);
}
