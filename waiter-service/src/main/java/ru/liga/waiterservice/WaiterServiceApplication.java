package ru.liga.waiterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Сервис для работы с заказами на стороне официантов.
 */
@SpringBootApplication
public class WaiterServiceApplication {

    /**
     * Запуск приложения waiter-service.
     *
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) {
        SpringApplication.run(WaiterServiceApplication.class, args);
    }
}
