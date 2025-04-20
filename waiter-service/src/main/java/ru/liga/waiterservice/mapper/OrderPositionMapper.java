package ru.liga.waiterservice.mapper;

import org.mapstruct.Mapper;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.entity.OrderPositionEntity;
import java.util.List;

/**
 * Маппер для работы с информауией о блюде
 */
@Mapper(componentModel = "spring")
public interface OrderPositionMapper {

    /**
     * Преобразовать {@link OrderPositionDto} в {@link OrderPositionEntity}
     *
     * @param orderPositionDto информация о блюде
     * @param orderNo id заказа
     * @return {@link OrderPositionEntity}
     */
    OrderPositionEntity toEntity(OrderPositionDto orderPositionDto,
                                 Long orderNo);

    /**
     * Преобразовать список {@link OrderPositionEntity} в список {@link OrderPositionDto}
     * @param orderPositionEntityList список блюд из БД
     * @return Список {@link OrderPositionDto} для отправки на кухню
     */
    List<OrderPositionDto> toDtoList(List<OrderPositionEntity> orderPositionEntityList);

}
