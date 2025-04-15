package ru.liga.waiterservice.model.dto;

import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import java.time.OffsetDateTime;

/**
 * DTO для взаимодействия с заказом на стороне waiter-service
 */
@Data
public class WaiterOrderDto {

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
