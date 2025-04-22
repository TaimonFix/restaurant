package ru.liga.kitchenservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * DTO - заказ, поступивший из waiter-service.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderFromWaiterDto {

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
    private List<DishDto> positions;
}
