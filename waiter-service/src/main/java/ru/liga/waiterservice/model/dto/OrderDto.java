package ru.liga.waiterservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Dto с данными о созданном заказе.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dto полученного заказа от клиента")
public class OrderDto {

    /**
     * id официанта.
     */
    @NotNull(message = "Введите id официанта")
    @Schema(description = "id официанта", example = "1")
    private Long waiterId;

    /**
     * Номер столика.
     */
    @NotEmpty(message = "Введите номер столика")
    @Schema(description = "Номер столика", example = "Столик №1")
    private String tableNo;


    /**
     * Список заказанных блюд.
     */
    @NotEmpty(message = "Введите список заказанных блюд")
    @Schema(description = "Список заказанных блюд")
    private List<OrderPositionDto> positions;
}
