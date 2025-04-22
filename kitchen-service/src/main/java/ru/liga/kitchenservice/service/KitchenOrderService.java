package ru.liga.kitchenservice.service;

import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import java.util.List;

/**
 * Сервис для работы с заказами.
 */
public interface KitchenOrderService {

    /**
     * Получить все заказы.
     *
     * @return Список {@link KitchenOrderDto} заказов
     */
    List<KitchenOrderDto> getOrders();

    /**
     * Сохранить заказ в БД.
     *
     * @param orderFromWaiterDto заказ, присланный из сервиса официантов
     * @return {@link Long} id сформированного заказа
     */
    Long saveOrder(OrderFromWaiterDto orderFromWaiterDto);

    /**
     * Обновить статус заказа.
     *
     * @param id     идентификатор заказа
     * @param status обновленный статус
     * @throws IllegalArgumentException в случае, если полученный status отсутствует в enum
     */
    void updateOrderStatus(Long id, String status);
}
