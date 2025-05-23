package ru.liga.waiterservice.mapper;


import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;

import java.util.List;

/**
 * Маппер для создания заказа, который будет направлен на сторону kitchen-service.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface KitchenOrderMapper {

    /**
     * Маппинг ({@link WaiterOrderDto}, список {@link OrderPositionDto}) -> {@link KitchenOrderDto}.
     *
     * @param waiterOrderDto данные о заказе со стороны сервиса официантов
     * @param positions список заказанных позиций блюд
     * @return {@link KitchenOrderDto} данные о заказе со стороны сервиса кухни.
     */
    @Mapping(target = "waiterOrderNo", source = "waiterOrderDto.orderNo")
    KitchenOrderDto toDto(WaiterOrderDto waiterOrderDto,
                          List<OrderPositionDto> positions);
}
