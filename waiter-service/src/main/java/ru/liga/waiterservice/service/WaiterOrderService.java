package ru.liga.waiterservice.service;

import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.util.List;

public interface WaiterOrderService {
    /**
     * Получить все заказы
     */
    List<WaiterOrderDto> getOrders();

    /**
     * Получить заказ
     *
     * @param id идентификатор заказа
     */
    WaiterOrderDto getOrder(Long id);

    /**
     * Добавить заказ
     */
    Long saveOrder(WaiterOrderDto orderDto);

    /**
     * Получить статус заказа
     *
     * @param id идентификатор заказа
     */
    OrderStatus getOrderStatus(Long id);
}
