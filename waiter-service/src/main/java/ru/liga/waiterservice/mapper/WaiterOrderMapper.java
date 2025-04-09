package ru.liga.waiterservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.entity.WaiterOrderEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WaiterOrderMapper {

    @Mapping(target = "orderNo", source = "orderNo")
    WaiterOrderDto toDto(WaiterOrderEntity waiterOrderEntity);

    @Mapping(target = "orderNo", source = "orderNo")
    WaiterOrderEntity toEntity(WaiterOrderDto waiterOrderdto);

    List<WaiterOrderDto> toDtoList(List<WaiterOrderEntity> kitchenOrders);

    @Mapping(target = "waiterOrderNo", source = "orderNo")
    KitchenOrderDto toKitchenOrderDto(WaiterOrder waiterOrder);
}
