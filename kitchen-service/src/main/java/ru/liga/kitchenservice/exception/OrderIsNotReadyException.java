package ru.liga.kitchenservice.exception;

/**
 * Исключение, возникающее в случае, если заказ на кухне еще не готов
 */
public class OrderIsNotReadyException extends RuntimeException {

    public OrderIsNotReadyException() {
      super("Заказ еще не готов!");
    }
}
