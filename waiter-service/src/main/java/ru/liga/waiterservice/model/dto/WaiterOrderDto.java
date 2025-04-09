package ru.liga.waiterservice.model.dto;

import lombok.Data;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import java.time.OffsetDateTime;

/**
 * DTO для хранения заказа, поступившего от клиента
 */
@Data
public class WaiterOrderDto {
    private Long orderNo;
    private OrderStatus status;
    private OffsetDateTime createDttm;
    private Long waiterId;
    private String tableNo;
}
