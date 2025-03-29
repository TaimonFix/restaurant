package ru.liga.waiterservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import ru.liga.waiterservice.dto.enums.Status;

import java.time.LocalDateTime;

/**
 * DTO для хранения заказа, поступившего от клиента
 */
@Getter
@Setter
@ToString
public class OrderDto {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime orderDate;
    private String description;
    private Float price;
    private Status status;

    // При получении заказ будет иметь статус "Новый"
    public OrderDto(LocalDateTime orderDate, String description, Float price) {
        this.orderDate = orderDate;
        this.description = description;
        this.price = price;
        this.status = Status.NEW;
    }
}
