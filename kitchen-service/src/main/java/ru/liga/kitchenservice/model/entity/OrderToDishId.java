package ru.liga.kitchenservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

/**
 * Композитный ключ i-го поля в таблице 'order-to-dish'.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class OrderToDishId implements java.io.Serializable {

    /**
     * Сериализация объекта.
     */
    private static final long serialVersionUID = 3938159353249121385L;

    /**
     * id заказа.
     */
    @NotNull
    @Column(name = "kitchen_order_id")
    private Long kitchenOrderId;

    /**
     * id блюда.
     */
    @NotNull
    @Column(name = "dish_id")
    private Long dishId;
}
