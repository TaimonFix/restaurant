package ru.liga.kitchenservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;
import java.time.OffsetDateTime;

/**
 * DTO - взаимодействие с заказом на стороне kitchen-service.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO для взаимодействия с заказом на стороне kitchen-service")
public class KitchenOrderDto {

    /**
     * id заказа со стороны kitchen-service.
     */
    @Schema(description = "Номер заказа со стороны сервиса кухни",
            example = "1")
    private Long kitchenOrderId;

    /**
     * id заказа со стороны waiter-service.
     */
    @Schema(description = "Номер заказа со стороны сервиса официантов",
            example = "1")
    private Long waiterOrderNo;

    /**
     * Статус заказа.
     */
    @Schema(description = "Статус заказа", defaultValue = "NEW")
    private OrderStatus status = OrderStatus.NEW;

    /**
     * Время создания заказа.
     */
    @Schema(description = "Время создания заказа",
            example = "2025-04-17T08:26:11.890Z")
    private OffsetDateTime createDttm;
}
