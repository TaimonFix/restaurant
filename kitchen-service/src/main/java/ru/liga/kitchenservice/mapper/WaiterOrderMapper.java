package ru.liga.kitchenservice.mapper;


import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;
import ru.liga.kitchenservice.model.entity.KitchenOrder;

/**
 * Маппер для обновления заказа, который будет отправлен на waiter-service.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface WaiterOrderMapper {

    /**
     * Маппинг: {@link OrderFromWaiterDto} -> {@link WaiterOrderDto}.
     *
     * @param orderFromWaiterDto данные о заказе из сервиса официантов
     * @return {@link WaiterOrderDto} dto заказа, которое будет отправлено
     * на сторону сервиса официантов.
     */
    @Mapping(target = "orderNo", source = "waiterOrderNo")
    WaiterOrderDto toWaiterOrderDto(OrderFromWaiterDto orderFromWaiterDto);

    /**
     * Маппинг: {@link KitchenOrder} -> {@link WaiterOrderDto}.
     *
     * @param kitchenOrder сущность "заказ"
     * @return {@link WaiterOrderDto} dto заказа, которое будет отправлено
     * на сторону сервиса официантов.
     */
    @Mapping(target = "orderNo", source = "waiterOrderNo")
    WaiterOrderDto toWaiterOrderDto(KitchenOrder kitchenOrder);
}
