package ru.liga.waiterservice.model.entity;


import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.Status;

import java.time.OffsetDateTime;

@Data
public class WaiterOrder {
    private Long orderNo;
    private Status status;
    private OffsetDateTime createDttm;
    private Long waiterId;
    private String tableNo;
}
