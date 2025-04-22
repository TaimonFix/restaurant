package ru.liga.waiterservice.model.dto.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * Статус заказа.
 */
@Slf4j
public enum OrderStatus {

    /**
     * Новый.
     */
    NEW,

    /**
     * В обработке.
     */
    IN_PROCESSING,

    /**
     * Принят.
     */
    APPROVED,

    /**
     * Отклонен.
     */
    REJECTED,

    /**
     * Готов.
     */
    READY;

    /**
     * Статический метод для чтения статуса из строки.
     *
     * @param status строковое значение, содержащее статус
     * @return {@link OrderStatus} статус заказа
     * @throws IllegalArgumentException если переданное значение
     * не соответствует значениям {@link OrderStatus}
     */
    public static OrderStatus getStatusFromString(final String status) {
        for (OrderStatus currentStatus: OrderStatus.values()) {
            if (currentStatus.toString().equals(status)) {
                return currentStatus;
            }
        }
        log.warn("Статус '{}' отсутствует!", status);
        throw new IllegalArgumentException("Статус '" + status + "' отсутствует.");
    }
}
