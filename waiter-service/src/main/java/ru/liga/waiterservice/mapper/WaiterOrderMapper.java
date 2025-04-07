package ru.liga.waiterservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.Status;

import java.util.List;

@Mapper
@Repository
public interface WaiterOrderMapper {

    List<WaiterOrderDto> getOrders();

    WaiterOrderDto getOrder(@Param("id") Long id);

    void addOrder(@Param("order") WaiterOrderDto order);

    Status getStatus(@Param("id") Long id);
}
