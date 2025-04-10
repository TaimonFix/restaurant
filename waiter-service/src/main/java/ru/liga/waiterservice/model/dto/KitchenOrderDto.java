package ru.liga.waiterservice.model.dto;

import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

/**
 * Dto для взаимодействия с kitchen-service по API
 */
@Data
public class KitchenOrderDto {

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
}
