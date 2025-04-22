package ru.liga.waiterservice.service;

import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import java.util.List;

/**
 * Сервис для учета блюд в заказе клиента.
 */
public interface OrderPositionsService {

    /**
     * Получить все блюда из заказа.
     *
     * @param orderNo id заказа
     * @return Список {@link OrderPositionDto} блюд
     */
    List<OrderPositionDto> findOrderPositionsByOrderNo(Long orderNo);

    /**
     * Сохранить все позиции из заказа.
     *
     * @param orderDto информация о созданном заказе
     * @param orderNo номер заказа
     */
    void saveOrderPositions(OrderDto orderDto, Long orderNo);
}
