package ru.liga.waiterservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Dto, хранящее информацию о заказанном блюде
 */
@Data
public class OrderPositionDto {

    /**
     * id блюда из таблицы 'menu'
     */
    @NotBlank(message = "Введите id блюда")
    private Long menuPositionId;

    /**
     * Количество заказанных блюд
     */
    @NotBlank(message = "Введите количество блюд")
    private Long dishNum;
}
