package ru.liga.waiterservice.service;

import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.util.List;

/**
 * Сервис для работы с заказами
 */
public interface WaiterOrderService {

    /**
     * Получить все заказы
     *
     * @return список заказов
     */
    List<WaiterOrderDto> getOrders();

    /**
     * Получить заказ
     *
     * @param id идентификатор заказа
     * @return DTO заказа
     */
    WaiterOrderDto getOrder(Long id);

    /**
     * Добавить заказ
     *
     * @param orderDto DTO заказа, который нужно сохранить
     * @return id сохраненного заказа
     */
    Long saveOrder(OrderDto orderDto);

    /**
     * Получить статус заказа
     *
     * @param id идентификатор заказа
     * @return статус заказа
     */
    OrderStatus getOrderStatus(Long id);

    /**
     * Обновить данные о заказе
     *
     * @param orderDto DTO заказа, который нужно обновить
     * @return id обновленного заказа
     */
    Long updateOrder(WaiterOrderDto orderDto);

    /**
     * Формирование KitchenOrderDto - новый заказ, который отправим на сторону кухни
     *
     * @param id идентификатор заказа со стороны официантов
     * @return DTO для последующей отправки в kitchen-service
     */
//    KitchenOrderDto toKitchenOrderDto(Long id);
}
