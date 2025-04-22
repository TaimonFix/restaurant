package ru.liga.waiterservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import java.time.OffsetDateTime;

/**
 * DTO для взаимодействия с заказом на стороне waiter-service.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dto, предназначенное для отправки данных в таблицу 'waiter-order'")
public class WaiterOrderDto {

    /**
     * id заказа.
     */
    @Schema(description = "Номер заказа", example = "1")
    private Long orderNo;

    /**
     * Статус заказа.
     */
    @Schema(description = "Статус заказа", defaultValue = "NEW")
    @Builder.Default
    private OrderStatus status = OrderStatus.NEW;

    /**
     * Время создания заказа.
     */
    @Schema(description = "Время создания заказа", example = "2025-04-17T08:26:11.890Z")
    @Builder.Default
    private OffsetDateTime createDttm = OffsetDateTime.now();

    /**
     * id официанта.
     */
    @Schema(description = "id официанта", example = "1")
    private Long waiterId;

    /**
     * Номер столика.
     */
    @Schema(description = "Номер столика", example = "Столик №1")
    private String tableNo;
}
