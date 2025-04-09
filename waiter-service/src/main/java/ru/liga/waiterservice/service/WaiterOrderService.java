package ru.liga.waiterservice.service;

import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.Status;

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
    Status getStatus(Long id);

    /**
     * Обновить данные о заказе
     */
    Long updateOrder(WaiterOrderDto orderDto);

    /**
     * Взять WaiterOrder из БД и перевести в KitchenOrderDto для отправки в kitchen-service
     * @param id идентификатор заказа со стороны официантов
     * @return
     */
    KitchenOrderDto toKitchenOrderDto(Long id);
}
