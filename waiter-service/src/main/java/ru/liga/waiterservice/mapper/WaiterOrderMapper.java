package ru.liga.waiterservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.entity.WaiterOrder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WaiterOrderMapper {

    @Mapping(target = "orderNo", source = "orderNo")
    WaiterOrderDto toDto(WaiterOrder waiterOrder);

    @Mapping(target = "orderNo", source = "orderNo")
    WaiterOrder toEntity(WaiterOrderDto waiterOrderdto);

    List<WaiterOrderDto> toDtoList(List<WaiterOrder> kitchenOrders);


}
