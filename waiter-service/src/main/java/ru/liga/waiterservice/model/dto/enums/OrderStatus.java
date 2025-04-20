package ru.liga.waiterservice.model.dto.enums;

/**
 * Статус заказа
 */
public enum OrderStatus {

    /**
     * Новый
     */
    NEW,

    /**
     * В обработке
     */
    IN_PROCESSING,

    /**
     * Принят
     */
    APPROVED,

    /**
     * Отклонен
     */
    REJECTED,

    /**
     * Готов
     */
    READY;

    /**
     * Статический метод для чтения статуса из строки
     * @param status строковое значение, содержащее статус
     * @return {@link OrderStatus} статус заказа
     * @throws IllegalArgumentException если переданное значение не соответсвует значениям {@link OrderStatus}
     */
    public static OrderStatus getStatusFromString(String status) {
        for (OrderStatus currentStatus: OrderStatus.values()) {
            if (currentStatus.toString().equals(status)) {
                return currentStatus;
            }
        }
        throw new IllegalArgumentException("Статус '" + status + "' отсутствует.");
    }
}
