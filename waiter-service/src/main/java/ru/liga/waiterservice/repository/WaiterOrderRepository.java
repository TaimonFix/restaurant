package ru.liga.waiterservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.model.entity.WaiterOrderEntity;

import java.util.List;

/**
 * Репозиторий для работы с заказами.
 */
@Mapper
@Repository
public interface WaiterOrderRepository {

    /**
     * Получить все заказы из БД.
     *
     * @return Список заказов
     */
    List<WaiterOrderEntity> getOrders();

    /**
     * Получить заказ из БД.
     *
     * @param id идентификатор заказа
     * @return {@link WaiterOrderEntity} заказ
     */
    WaiterOrderEntity getOrder(@Param("id") Long id);

    /**
     * Сохранить заказ в БД.
     *
     * @param order заказ
     */
    void saveOrder(WaiterOrderEntity order);

    /**
     * Получить статус заказа из БД.
     *
     * @param id идентификатор заказа
     * @return {@link OrderStatus} статус заказа
     */
    OrderStatus getStatus(@Param("id") Long id);

    /**
     * Обновить данные о заказе в БД.
     *
     * @param order заказ
     */
    void updateOrder(WaiterOrderEntity order);
}
