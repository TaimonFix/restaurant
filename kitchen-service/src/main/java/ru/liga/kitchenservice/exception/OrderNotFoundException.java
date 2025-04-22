package ru.liga.kitchenservice.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Исключение, возникающее в случае,
 * если заказ отсутствует в БД.
 */
@Slf4j
public class OrderNotFoundException extends RuntimeException {

    /**
     * Заказ не найден.
     *
     * @param id идентификатор заказа
     */
    public OrderNotFoundException(final Long id) {
        super("Заказ с номером '" + id + "' отсутствует");
        log.warn("Заказ с с id: '{}' отсутствует", id);
    }
}
