package ru.liga.kitchenservice.service;

import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;

import java.util.List;


public interface KitchenOrderService {

    /**
     * Получить все заказы
     */
    List<KitchenOrderDto> getOrders();

    /**
     * Сохранить заказ в БД
     * @Return id заказа
     */
    Long saveOrder(KitchenOrderDto kitchenDto);

    /**
     * Обновить статус заказа
     *
     * @Params id идентификатор заказа
     * @Params обновленный статус
     *
     * @throws IllegalArgumentException в случае, если полученный status отсутствует в enum
     */
    KitchenOrderDto updateOrderStatus(Long id, String status);

    /**
     * Сформировать WaiterOrderDto для отправки в waiter-service
     * @param id идентификатор заказа со стороны кухни
     */
    WaiterOrderDto getWaiterOrderDto(Long id);
}
