package ru.liga.waiterservice.model.entity;


import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;

import java.time.OffsetDateTime;

@Data
public class WaiterOrderEntity {
    private Long orderNo;
    private OrderStatus status;
    private OffsetDateTime createDttm;
    private Long waiterId;
    private String tableNo;
}
