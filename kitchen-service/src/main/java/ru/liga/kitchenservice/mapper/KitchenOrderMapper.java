package ru.liga.kitchenservice.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.model.entity.KitchenOrder;

import java.util.List;

/**
 * Маппер для работы с заказами на стороне кухни.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface KitchenOrderMapper {

    /**
     * Маппинг: {@link KitchenOrder} -> {@link KitchenOrderDto}.
     *
     * @param kitchenOrder данные о заказе из БД
     * @return {@link KitchenOrderDto} dto заказа
     */
    @Mapping(target = "kitchenOrderId", source = "id")
    KitchenOrderDto toDto(KitchenOrder kitchenOrder);

    /**
     * Маппинг: {@link OrderFromWaiterDto} -> {@link KitchenOrderDto}.
     *
     * @param orderFromWaiterDto данные о заказе из сервиса официантов
     * @return {@link KitchenOrder} сущность "заказ"
     */
    KitchenOrder toEntity(OrderFromWaiterDto orderFromWaiterDto);

    /**
     * Маппинг: Список {@link KitchenOrder} -> Список {@link KitchenOrderDto}.
     *
     * @param kitchenOrderList список сущностей "заказ"
     * @return {@link KitchenOrder} список dto "заказов"
     */
    List<KitchenOrderDto> toDtoList(List<KitchenOrder> kitchenOrderList);
}
