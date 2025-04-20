package ru.liga.kitchenservice.model.dto;

import lombok.Data;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Dto с заказом, поступившее из waiter-service
 */
@Data
public class OrderFromWaiterDto {

    /**
     * id заказа со стороны waiter-service
     */
    private Long waiterOrderNo;

    /**
     * Статус заказа
     */
    private OrderStatus status;

    /**
     * Время создания заказа
     */
    private OffsetDateTime createDttm;

    /**
     * Список блюд в заказе
     */
    private List<DishDto> positions;


}
