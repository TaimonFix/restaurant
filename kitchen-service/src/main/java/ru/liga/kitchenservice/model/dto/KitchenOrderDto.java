package ru.liga.kitchenservice.model.dto;

import lombok.*;
import ru.liga.kitchenservice.model.dto.enums.Status;

import java.time.OffsetDateTime;

@Data
public class KitchenOrderDto {
    private Long kitchenOrderId;
    private Long waiterOrderNo;
    private Status status = Status.NEW;
    private OffsetDateTime createDttm;
}
