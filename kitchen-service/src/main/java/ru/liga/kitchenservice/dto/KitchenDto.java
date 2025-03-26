package ru.liga.kitchenservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.liga.kitchenservice.dto.enums.Status;

import java.util.List;

@Getter
@Setter
@ToString
public class KitchenDto {
    private Long orderId;
    private List<String> ingredients;
    private Status status;

    // При поступлении на кухню, заказ будет иметь статус "Новый"
    public KitchenDto(Long orderId, List<String> ingredients) {
        this.orderId = orderId;
        this.ingredients = ingredients;
        this.status = Status.NEW;
    }
}
