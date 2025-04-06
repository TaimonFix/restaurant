package ru.liga.kitchenservice.model.dto;

import lombok.*;
import ru.liga.kitchenservice.model.dto.enums.Status;

import java.time.OffsetDateTime;

@Data
public class KitchenOrderDto {
    private Long kitchenOrderId;
    private Long waiterOrderNo;
    private Status status;
    private OffsetDateTime createDttm;

    // При поступлении на кухню, заказ будет иметь статус "Новый"
    public KitchenOrderDto(Long waiterOrderNo, OffsetDateTime createDttm) {
        this.waiterOrderNo = waiterOrderNo;
        this.status = Status.NEW;
        this.createDttm = createDttm;
    }

}
