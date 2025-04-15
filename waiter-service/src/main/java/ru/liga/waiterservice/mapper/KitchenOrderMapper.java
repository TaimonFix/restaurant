package ru.liga.waiterservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;

import java.util.List;

/**
 * Маппер для создания заказа, который будет направлен на сторону kitchen-service
 */
@Mapper(componentModel = "spring")
public interface KitchenOrderMapper {

    @Mapping(target = "waiterOrderNo", source = "waiterOrderDto.orderNo")
    KitchenOrderDto toDto(WaiterOrderDto waiterOrderDto,
                          List<OrderPositionDto> positions);
}
