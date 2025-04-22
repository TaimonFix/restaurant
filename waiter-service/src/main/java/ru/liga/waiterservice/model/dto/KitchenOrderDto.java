package ru.liga.waiterservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Dto для взаимодействия с kitchen-service по API (через Kafka).
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KitchenOrderDto {

    /**
     * id заказа со стороны waiter-service.
     */
    private Long waiterOrderNo;

    /**
     * Статус заказа.
     */
    private OrderStatus status;

    /**
     * Время создания заказа.
     */
    private OffsetDateTime createDttm;

    /**
     * Список блюд в заказе.
     */
    private List<OrderPositionDto> positions;
}
