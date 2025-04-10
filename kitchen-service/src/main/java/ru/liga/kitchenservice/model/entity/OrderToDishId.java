package ru.liga.kitchenservice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * id заказа
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderToDishId implements java.io.Serializable {
    private static final long serialVersionUID = 3938159353249121385L;

    /**
     * id заказа
     */
    @NotNull
    @Column(name = "kitchen_order_id")
    private Long kitchenOrderId;

    /**
     * id блюда
     */
    @NotNull
    @Column(name = "dish_id")
    private Long dishId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderToDishId entity = (OrderToDishId) o;
        return Objects.equals(this.dishId, entity.dishId) &&
                Objects.equals(this.kitchenOrderId, entity.kitchenOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, kitchenOrderId);
    }

}