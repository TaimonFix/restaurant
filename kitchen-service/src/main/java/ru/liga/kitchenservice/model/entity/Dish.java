package ru.liga.kitchenservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long id;

    @NotNull
    @Column(name = "balance")
    private Long balance;

    @NotNull
    @Column(name = "short_name")
    private String shortName;

    @NotNull
    @Column(name = "dish_composition")
    private String dishComposition;

}