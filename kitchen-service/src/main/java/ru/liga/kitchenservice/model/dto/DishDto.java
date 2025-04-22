package ru.liga.kitchenservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO - информация о блюде из заказа.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {

    /**
     * id блюда.
     */
    private Long menuPositionId;

    /**
     * Количество блюд.
     */
    private Long dishNum;
}
