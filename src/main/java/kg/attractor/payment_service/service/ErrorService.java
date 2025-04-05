package kg.attractor.payment_service.service;

import kg.attractor.payment_service.exceptions.ErrorResponseBody;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;

@Service
public class ErrorService {

    public ErrorResponseBody makeResponse(Exception e) {
        return ErrorResponseBody.builder()
                .title("Ошибка: " + e.getClass().getSimpleName())
                .response(Map.of("error", List.of(e.getMessage())))
                .build();
    }

    public ErrorResponseBody makeResponse(BindingResult bindingResult) {
        Map<String, List<String>> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errors.computeIfAbsent(error.getField(), key -> new ArrayList<>()).add(error.getDefaultMessage());
        });

        return ErrorResponseBody.builder()
                .title("Validation Error")
                .response(errors)
                .build();
    }
}