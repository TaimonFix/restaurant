package ru.liga.waiterservice.model.entity;

import lombok.Data;

/**
 * Информация о количестве заказанных блюд
 */
@Data
public class OrderPositionEntity {

    /**
     * id композиции заказ-блюдо
     */
    private Long compositionId;

    /**
     * Количество заказанных блюд
     */
    private Long dishNum;

    /**
     * id заказа
     */
    private Long orderNo;

    /**
     * id блюда
     */
    private Long menuPositionId;
}
