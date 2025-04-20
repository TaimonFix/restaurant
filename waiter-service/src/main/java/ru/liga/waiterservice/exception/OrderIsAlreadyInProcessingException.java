package ru.liga.waiterservice.exception;

public class OrderIsAlreadyInProcessingException extends RuntimeException {
    public OrderIsAlreadyInProcessingException() {
        super("Заказ уже в обработке!");
    }
}
