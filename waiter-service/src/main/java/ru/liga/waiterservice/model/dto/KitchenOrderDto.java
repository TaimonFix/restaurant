package ru.liga.waiterservice.model.dto;

import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

/**
 * Dto для взаимодействия с kitchen-service по API
 */
@Data
public class KitchenOrderDto {
    private Long waiterOrderNo;
    private OrderStatus status;
    private OffsetDateTime createDttm;
}
