package ru.liga.kitchenservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_to_dish")
public class OrderToDish {
    @EmbeddedId
    private OrderToDishId id;

    @MapsId("kitchenOrderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JoinColumn(name = "kitchen_order_id")
    private KitchenOrder kitchenOrder;

    @MapsId("dishId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @NotNull
    @Column(name = "dishes_number")
    private Long dishesNumber;

}