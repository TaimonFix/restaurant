package ru.liga.waiterservice.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Исключение, возникающее в случае, если заказ уже был отправлен на кухню.
 */
@Slf4j
public class OrderIsAlreadyInProcessingException extends RuntimeException {

    /**
     * Заказ уже отправлен на кухню.
     *
     * @param id идентификатор заказа
     */
    public OrderIsAlreadyInProcessingException(final Long id) {
        super("Заказ с номером '" + id + "' уже в обработке!");
        log.warn("Заказ с номером '{}' не может быть отправлен на кухню, так как его статус не равен 'NEW'", id);
    }
}
