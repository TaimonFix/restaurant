package ru.liga.waiterservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.model.entity.WaiterOrderEntity;

import java.util.List;

@Mapper
@Repository
public interface WaiterOrderRepository {

    List<WaiterOrderEntity> getOrders();

    WaiterOrderEntity getOrder(@Param("id") Long id);

    void addOrder(WaiterOrderEntity order);

    OrderStatus getStatus(@Param("id") Long id);
}
