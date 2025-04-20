package ru.liga.waiterservice.service;

/**
 * Сервис для формирования заказа на отправку в kitchen-service
 */
public interface KitchenOrderService {

    /**
     * Отправить заказ на кухню
     *
     * @param id идентификатор заказа
     */
    void postOrderToTheKitchen(Long id);
}
