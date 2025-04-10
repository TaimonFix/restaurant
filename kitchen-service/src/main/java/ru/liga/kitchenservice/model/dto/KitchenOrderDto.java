package ru.liga.kitchenservice.model.dto;

import lombok.*;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

/**
 * DTO для взаимодействия с заказом на стороне kitchen-service
 */
@Data
public class KitchenOrderDto {

    /**
     * id заказа со стороны kitchen-service
     */
    private Long kitchenOrderId;

    /**
     * id заказа со стороны waiter-service
     */
    private Long waiterOrderNo;

    /**
     * Статус заказа
     */
    private OrderStatus status = OrderStatus.NEW;

    /**
     * Время создания заказа
     */
    private OffsetDateTime createDttm;
}
