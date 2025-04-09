package ru.liga.kitchenservice.model.dto;

import lombok.Data;
import ru.liga.kitchenservice.model.dto.enums.Status;

import java.time.OffsetDateTime;

/**
 * DTO для взаимодействия по API с waiter-service
 */
@Data
public class WaiterOrderDto {
    private Long orderNo;
    private Status status;
    private OffsetDateTime createDttm;
}
