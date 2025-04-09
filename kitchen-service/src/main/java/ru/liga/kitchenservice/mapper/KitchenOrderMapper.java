package ru.liga.kitchenservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;
import ru.liga.kitchenservice.model.entity.KitchenOrder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KitchenOrderMapper {

    @Mapping(target = "kitchenOrderId", source = "id")
    KitchenOrderDto toDto(KitchenOrder kitchenOrder);

    @Mapping(target = "id", source = "kitchenOrderId")
    KitchenOrder toEntity(KitchenOrderDto kitchenOrderdto);

    List<KitchenOrderDto> toDtoList(List<KitchenOrder> kitchenOrders);

    @Mapping(target = "orderNo", source = "waiterOrderNo")
    WaiterOrderDto toWaiterOrderDto(KitchenOrder kitchenOrder);
}
