package ru.liga.waiterservice.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.entity.WaiterOrderEntity;

import java.util.List;

/**
 * Маппер для работы с заказами.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface WaiterOrderMapper {

    /**
     * Маппинг: {@link WaiterOrderEntity} -> {@link WaiterOrderDto}.
     *
     * @param waiterOrderEntity сущность заказа из БД
     * @return {@link WaiterOrderDto} dto заказа на стороне сервиса официантов
     */
    @Mapping(target = "orderNo", source = "orderNo")
    WaiterOrderDto toDto(WaiterOrderEntity waiterOrderEntity);

    /**
     * Маппинг: {@link WaiterOrderDto} -> {@link WaiterOrderEntity}.
     *
     * @param waiterOrderDto dto заказа на стороне сервиса официантов
     * @return {@link WaiterOrderEntity} сущность заказа для передачи в БД
     */
    @Mapping(target = "orderNo", source = "orderNo")
    WaiterOrderEntity toEntity(WaiterOrderDto waiterOrderDto);


    /**
     * Маппинг: {@link OrderDto} -> {@link WaiterOrderDto}.
     *
     * @param orderDto dto с информацией о заказе, поступившее от клиента
     * @return {@link WaiterOrderDto} dto заказа на стороне сервиса официантов
     */
    WaiterOrderDto toDto(OrderDto orderDto);


    /**
     * Маппинг: список {@link WaiterOrderEntity} -> список {@link WaiterOrderDto}.
     *
     * @param waiterOrderEntityList список сущностей заказов из БД
     * @return {@link WaiterOrderDto} список dto заказов на стороне сервиса официантов
     */
    List<WaiterOrderDto> toDtoList(List<WaiterOrderEntity> waiterOrderEntityList);
}
