package ru.liga.waiterservice.model.entity;


import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

/**
 * Заказ на стороне waiter-service
 */
@Data
public class WaiterOrderEntity {

    /**
     * id заказа
     */
    private Long orderNo;

    /**
     * Статус заказа
     */
    private OrderStatus status = OrderStatus.NEW;

    /**
     * Время создания заказа
     */
    private OffsetDateTime createDttm;

    /**
     * id официанта
     */
    private Long waiterId;

    /**
     * Номер столика
     */
    private String tableNo;
}
