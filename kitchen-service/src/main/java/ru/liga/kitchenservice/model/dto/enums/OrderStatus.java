package ru.liga.kitchenservice.model.dto.enums;

/**
 * Статус заказа
 */
public enum OrderStatus {
    NEW, // новый
    APPROVED, // принят
    REJECTED, // отклонен
    READY; // готов

    public static OrderStatus getStatusFromString(String status) {
        for (OrderStatus currentStatus: OrderStatus.values()) {
            if (currentStatus.toString().equals(status)) {
                return currentStatus;
            }
        }
        throw new IllegalArgumentException("Статус '"+ status + "' отсутствует.");
    }
}
