package ru.liga.kitchenservice.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.liga.kitchenservice.model.dto.enums.Status;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "kitchen_order")
public class KitchenOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kitchen_order_id")
    private Long id;

    @NotNull
    @Column(name = "waiter_order_no")
    private Long waiterOrderNo;

    @NotNull
    @Column(name = "status")
    private String status;

    @NotNull
    @Column(name = "create_dttm")
    private OffsetDateTime createDttm;

}