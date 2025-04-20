package ru.liga.waiterservice.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Dto с данными о созданном заказе
 */
@Data
public class OrderDto {

    /**
     * id заказа со стороны waiter-service
     */
    private Long orderNo;

    /**
     * Время создания заказа
     */
    private OffsetDateTime createDttm = OffsetDateTime.now();

    /**
     * id официанта
     */
    @NotNull(message = "Введите id официанта")
    private Long waiterId;

    /**
     * Номер столика
     */
    @NotEmpty(message = "Введите номер столика")
    private String tableNo;


    /**
     * Список заказанных блюд
     */
    @NotEmpty(message = "Введите список заказанных блюд")
    private List<OrderPositionDto> positions;
}
