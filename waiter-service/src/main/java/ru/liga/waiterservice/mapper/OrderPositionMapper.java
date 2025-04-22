package ru.liga.waiterservice.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.entity.OrderPositionEntity;
import java.util.List;

/**
 * Маппер для работы с информауией о блюде.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OrderPositionMapper {

    /**
     * Маппинг: ({@link OrderPositionDto}, {@link Long}) -> {@link OrderPositionEntity}.
     *
     * @param orderPositionDto информация о блюде
     * @param orderNo id заказа
     * @return {@link OrderPositionEntity} сущность "Позиции заказа"
     */
    OrderPositionEntity toEntity(OrderPositionDto orderPositionDto,
                                 Long orderNo);

    /**
     * Маппинг: список {@link OrderPositionEntity} -> {@link OrderPositionDto}.
     *
     * @param orderPositionEntityList список блюд из БД
     * @return Список {@link OrderPositionDto} для отправки на кухню
     */
    List<OrderPositionDto> toDtoList(List<OrderPositionEntity> orderPositionEntityList);
}
