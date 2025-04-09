package ru.liga.waiterservice.model.dto;

import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.Status;

import java.time.OffsetDateTime;

/**
 * Dto взаимодействия с kitchen-service по API
 */
@Data
public class KitchenOrderDto {
    private Long waiterOrderNo;
    private Status status;
    private OffsetDateTime createDttm;
}
