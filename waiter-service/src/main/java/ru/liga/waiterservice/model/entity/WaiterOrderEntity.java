package ru.liga.waiterservice.model.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

/**
 * Заказ на стороне waiter-service.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WaiterOrderEntity {

    /**
     * id заказа.
     */
    private Long orderNo;

    /**
     * Статус заказа.
     */
    private OrderStatus status;

    /**
     * Время создания заказа.
     */
    private OffsetDateTime createDttm;

    /**
     * id официанта.
     */
    private Long waiterId;

    /**
     * Номер столика.
     */
    private String tableNo;
}
