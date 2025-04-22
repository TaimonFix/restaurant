package ru.liga.kitchenservice.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Промежуточная таблица для реализации связи 'Многие-ко-многим'
 * между таблицами 'kitchen-order', 'dish'.
 */
@Getter
@Setter
@Entity
@Table(name = "order_to_dish")
public class OrderToDish {
    /**
     * Композитный ключ.
     */
    @EmbeddedId
    private OrderToDishId id;

    /**
     * id заказа.
     */
    @MapsId("kitchenOrderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JoinColumn(name = "kitchen_order_id")
    private KitchenOrder kitchenOrder;

    /**
     * id блюда.
     */
    @MapsId("dishId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JoinColumn(name = "dish_id")
    private Dish dish;

    /**
     * Количество блюд на кухне.
     */
    @NotNull
    @Column(name = "dishes_number")
    private Long dishesNumber;
}
