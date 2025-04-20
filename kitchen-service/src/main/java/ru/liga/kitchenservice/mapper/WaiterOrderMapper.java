package ru.liga.kitchenservice.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;

/**
 * Маппер для обновления заказа, который будет отправлен на waiter-service
 */
@Mapper(componentModel = "spring")
public interface WaiterOrderMapper {

    @Mapping(target = "orderNo", source = "waiterOrderNo")
    WaiterOrderDto toWaiterOrderDto(OrderFromWaiterDto orderFromWaiterDto);
}
