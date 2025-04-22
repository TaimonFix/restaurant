package ru.liga.kitchenservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

/**
 * DTO - взаимодействие по API с waiter-service.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaiterOrderDto {

    /**
     * id заказа со стороны waiter-service.
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
}
