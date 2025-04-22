package ru.liga.waiterservice.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Информация о количестве заказанных блюд.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderPositionEntity {

    /**
     * id композиции заказ-блюдо.
     */
    private Long compositionId;

    /**
     * Количество заказанных блюд.
     */
    private Long dishNum;

    /**
     * id заказа.
     */
    private Long orderNo;

    /**
     * id блюда.
     */
    private Long menuPositionId;
}
