package ru.liga.waiterservice.service;

import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.entity.OrderPositionEntity;

import java.util.List;

/**
 * Сервис для работы учета блюд в заказе клиента
 */
public interface OrderPositionsService {

    /**
     * Получить все блюда из заказа
     *
     * @param orderNo id заказа
     * @return Список блюд {@link OrderPositionDto}
     */
    List<OrderPositionDto> findOrderPositionsByOrderNo(Long orderNo);
    /**
     * Сохранить все позиции из заказа
     *
     * @param orderDto информация о созданном заказе
     */
    void saveOrderPositions(OrderDto orderDto);
}
