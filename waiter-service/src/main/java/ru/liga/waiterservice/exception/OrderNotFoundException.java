package ru.liga.waiterservice.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Исключение, возникающее в случае, если заказ под указанным id не был найден.
 */
@Slf4j
public class OrderNotFoundException extends RuntimeException {

    /**
     * Заказ не найден.
     *
     * @param id идентификатор заказа
     */
    public OrderNotFoundException(final Long id) {
        super("Заказ с номером '" + id + "' не найден");
        log.warn("Заказ с номером {} не найден", id);
    }
}
