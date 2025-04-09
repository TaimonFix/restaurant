package ru.liga.kitchenservice.model.dto;

import lombok.*;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

@Data
public class KitchenOrderDto {
    private Long kitchenOrderId;
    private Long waiterOrderNo;
    private OrderStatus status = OrderStatus.NEW;
    private OffsetDateTime createDttm;



}
