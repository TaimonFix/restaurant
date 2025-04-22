package ru.liga.waiterservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto, хранящее информацию о заказанном блюде.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dto, хранящее информацию о заказанном блюде")
public class OrderPositionDto {

    /**
     * id блюда из таблицы 'menu'.
     */
    @NotBlank(message = "Введите id блюда")
    @Schema(description = "id блюда из таблицы 'menu'", example = "1")
    private Long menuPositionId;

    /**
     * Количество заказанных блюд.
     */
    @NotBlank(message = "Введите количество блюд")
    @Schema(description = "Количество заказанных блюд", example = "5")
    private Long dishNum;
}
