package ru.liga.kitchenservice.model.dto;

import lombok.Data;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

/**
 * DTO для взаимодействия по API с waiter-service
 */
@Data
public class WaiterOrderDto {

    /**
     * id заказа со стороны waiter-service
     */
    private Long orderNo;

    /**
     * Статус заказа
     */
    private OrderStatus status;

    /**
     * Время создания заказа
     */
    private OffsetDateTime createDttm;
}
