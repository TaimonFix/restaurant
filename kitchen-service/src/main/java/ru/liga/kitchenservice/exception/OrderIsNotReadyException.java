package ru.liga.kitchenservice.exception;

public class OrderIsNotReadyException extends RuntimeException {
    public OrderIsNotReadyException(String message) {
        super(message);
    }

    public OrderIsNotReadyException() {
      super("Заказ еще не готов!");
    }
}
