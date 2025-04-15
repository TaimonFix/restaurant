package ru.liga.kitchenservice.model.dto;

import lombok.Data;

/**
 * Информация о блюде из заказа
 */
@Data
public class DishDto {

    /**
     * id блюда
     */
    private Long menuPositionId;

    /**
     * Количество блюд
     */
    private Long dishNum;
}
