package ru.liga.waiterservice.model.dto;

import lombok.Builder;
import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.Status;
import java.time.OffsetDateTime;

/**
 * DTO для хранения заказа, поступившего от клиента
 */
@Data
public class WaiterOrderDto {
    private Long orderNo;
    private Status status = Status.NEW;
    private OffsetDateTime createDttm;
    private Long waiterId;
    private String tableNo;
}
