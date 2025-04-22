package ru.liga.kitchenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Сервис для работы с заказами на стороне кухни.
 */
@EnableFeignClients
@SpringBootApplication
public class KitchenServiceApplication {

    /**
     * Запуск приложения kitchen-service.
     *
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) {
        SpringApplication.run(KitchenServiceApplication.class, args);
    }
}
