package ru.liga.kitchenservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Блюдо
 */
@Getter
@Setter
@Entity
@Table(name = "dish")
public class Dish {

    /**
     * Идентификатор блюда
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long id;

    /**
     * Количество блюд на кухне
     */
    @NotNull
    @Column(name = "balance")
    private Long balance;

    /**
     * Короткое название блюда
     */
    @NotNull
    @Column(name = "short_name")
    private String shortName;

    /**
     * Состав блюда
     */
    @NotNull
    @Column(name = "dish_composition")
    private String dishComposition;

}