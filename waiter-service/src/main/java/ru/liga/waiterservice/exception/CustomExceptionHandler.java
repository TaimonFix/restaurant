package ru.liga.waiterservice.exception;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Общий обработчик исключений.
 */
@ControllerAdvice
@Hidden
public class CustomExceptionHandler {

    /**
     * Общий обработчик исключений, связанных с заказами.
     *
     * @param exc Исключение
     * @return {@link ResponseEntity}, содержащий информацию
     * об исключении, а также статус ошибки
     */
    @ExceptionHandler(value = {OrderNotFoundException.class, OrderPositionsListIsEmptyException.class})
    public ResponseEntity<Object> handleOrderExceptions(final RuntimeException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Общий обработчик исключений, связанных с заказами, которые уже отправлены на кухню.
     *
     * @param exc Исключение
     * @return {@link ResponseEntity}, содержащий информацию
     * об исключении, а также статус ошибки
     */
    @ExceptionHandler(value = {OrderIsAlreadyInProcessingException.class})
    public ResponseEntity<Object> handleOrderProcessingExceptions(final OrderIsAlreadyInProcessingException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * Общий обработчик исключений, связанных с валидацией данных.
     *
     * @param exc Исключение
     * @return {@link ResponseEntity}, содержащий информацию
     * об исключении, а также статус ошибки
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(final MethodArgumentNotValidException exc) {
        Map<String, String> errors = new HashMap<>();
        exc.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
