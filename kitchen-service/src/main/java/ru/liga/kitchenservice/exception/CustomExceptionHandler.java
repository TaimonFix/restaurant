package ru.liga.kitchenservice.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;

/**
 * Общий обработчик исключений.
 */
@ControllerAdvice
@Hidden
@Slf4j
public class CustomExceptionHandler {

    /**
     * Общий обработчик исключений, связанных с заказами.
     *
     * @param exc Исключение
     * @return {@link ResponseEntity}, содержащий информацию
     * об исключении, а также статус ошибки
     */
    @ExceptionHandler(value =
            {OrderNotFoundException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handleOrderExceptions(
            final RuntimeException exc) {
        log.error(exc.getMessage(), exc);
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Общий обработчик исключений, связанных с подключением.
     *
     * @param exc Исключение
     * @return {@link ResponseEntity}, содержащий информацию
     * об исключении, а также статус ошибки
     */
    @ExceptionHandler(value = {ConnectException.class})
    public ResponseEntity<Object> handleConnectException(
            final ConnectException exc) {
        String message = "Подключение к сервису официантов "
                + "(waiter-service) недоступно!";
        log.error(message, exc);
        return new ResponseEntity<>(message, HttpStatus.BAD_GATEWAY);
    }
}
