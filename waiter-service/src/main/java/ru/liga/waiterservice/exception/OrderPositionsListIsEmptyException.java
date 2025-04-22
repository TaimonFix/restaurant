package ru.liga.waiterservice.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Исключение, возникающее в случае, если переданный список позиций пуст.
 */
@Slf4j
public class OrderPositionsListIsEmptyException extends RuntimeException {

    /**
     * Список позиций пуст.
     *
     * @param orderNo номер заказа
     */
    public OrderPositionsListIsEmptyException(final Long orderNo) {
        super("В заказе c номером '" + orderNo + "' отсутствуют позиции с блюдами!");
        log.warn("В заказе с номером {} отсутствуют позиции с блюдами!", orderNo);
    }
}
