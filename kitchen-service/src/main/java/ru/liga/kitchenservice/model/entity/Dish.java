package ru.liga.kitchenservice.model.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

/**
 * Сущность "Блюдо".
 */
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dish")
public class Dish {

    /**
     * Идентификатор блюда.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long id;

    /**
     * Количество блюд на кухне.
     */
    @NotNull
    @Column(name = "balance")
    private Long balance;

    /**
     * Короткое название блюда.
     */
    @NotNull
    @Column(name = "short_name")
    private String shortName;

    /**
     * Состав блюда.
     */
    @NotNull
    @Column(name = "dish_composition")
    private String dishComposition;
}
