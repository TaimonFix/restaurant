package ru.liga.waiterservice.service;

import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.util.List;

/**
 * Сервис для работы с заказами.
 */
public interface WaiterOrderService {

    /**
     * Получить все заказы.
     *
     * @return список {@link WaiterOrderDto} заказов
     */
    List<WaiterOrderDto> getOrders();

    /**
     * Получить заказ.
     *
     * @param id идентификатор заказа
     * @return {@link WaiterOrderDto} DTO заказа
     */
    WaiterOrderDto getOrder(Long id);

    /**
     * Сохранить заказ.
     *
     * @param orderDto DTO заказа, который нужно сохранить
     * @return id сохраненного заказа
     */
    Long saveOrder(OrderDto orderDto);

    /**
     * Получить статус заказа.
     *
     * @param id идентификатор заказа
     * @return {@link OrderStatus} статус заказа
     */
    OrderStatus getOrderStatus(Long id);

    /**
     * Обновить данные о заказе.
     *
     * @param waiterOrderDto DTO заказа, который нужно обновить
     * @return id обновленного заказа
     */
    Long updateOrder(WaiterOrderDto waiterOrderDto);
}
