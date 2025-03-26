package ru.liga.waiterservice.repository;

import org.springframework.stereotype.Repository;
import ru.liga.waiterservice.dto.OrderDto;
import ru.liga.waiterservice.dto.enums.Status;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
    private Map<Long, OrderDto> map;
    private Long index;

    // Временное решение, в ходе последующих ДЗ будет заменено на БД
    public OrderRepository() {
        this.map = new HashMap<>();
        this.index = 1L;
    }

    public Map<Long, OrderDto> getOrders() {
        return map;
    }

    public OrderDto getOrder(Long id) {
        return map.get(id);
    }

    public OrderDto addOrder(OrderDto orderDto) {
        return map.put(index++, orderDto);
    }

    public Status getStatus(Long id) {
        return map.get(id).getStatus();
    }
}
