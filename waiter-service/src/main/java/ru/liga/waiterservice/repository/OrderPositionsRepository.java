package ru.liga.waiterservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ru.liga.waiterservice.model.entity.OrderPositionEntity;

import java.util.List;

/**
 * Репозиторий для работы с блюдами в заказе
 */
@Repository
@Mapper
public interface OrderPositionsRepository {

    /**
     * Получить все блюда из заказа
     *
     * @param orderNo id заказа
     * @return Список блюд {@link OrderPositionEntity}
     */
    List<OrderPositionEntity> findByOrderNo(@Param("orderNo") Long orderNo);

    /**
     * Сохранить блюда из заказа в БД
     *
     * @param orderPosition
     */
    void saveOrderPosition(OrderPositionEntity orderPosition);
}
