package ru.liga.waiterservice.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ru.liga.waiterservice.model.dto.enums.Status;
import ru.liga.waiterservice.model.entity.WaiterOrder;

import java.util.List;

@Mapper
@Repository
public interface WaiterOrderRepository {

    List<WaiterOrder> getOrders();

    WaiterOrder getOrder(@Param("id") Long id);

    void saveOrder(WaiterOrder order);

    Status getStatus(@Param("id") Long id);

    void updateOrder(WaiterOrder order);
}
