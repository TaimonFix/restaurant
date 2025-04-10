package ru.liga.kitchenservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

/**
 * Заказ со стороны kitchen-service
 */
@Getter
@Setter
@Entity
@ToString
@Table(name = "kitchen_order")
public class KitchenOrder {

    /**
     * Идентификатор заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kitchen_order_id")
    private Long id;

    /**
     * Номер заказа со стороны waiter-service
     */
    @NotNull
    @Column(name = "waiter_order_no")
    private Long waiterOrderNo;

    /**
     * Статус заказа
     */
    @NotNull
    @Column(name = "status")
    private String status;

    /**
     * Время создания заказа
     */
    @NotNull
    @Column(name = "create_dttm")
    private OffsetDateTime createDttm;

}