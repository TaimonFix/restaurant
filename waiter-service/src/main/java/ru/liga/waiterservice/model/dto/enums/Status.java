package ru.liga.waiterservice.model.dto.enums;

/**
 * Статус заказа
 */
public enum Status {
    NEW, // новый
    APPROVED, // принят
    REJECTED, // отклонен
    READY; // готов

    public static Status getStatusFromString(String status) {
        for (Status currentStatus: Status.values()) {
            if (currentStatus.toString().equals(status)) {
                return currentStatus;
            }
        }
        throw new IllegalArgumentException("Статус '"+ status + "' отсутствует.");

    }
}
