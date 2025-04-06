package ru.liga.kitchenservice.repository;

import org.springframework.stereotype.Repository;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
    private Map<Long, KitchenOrderDto> map;
    private Long id;

    public OrderRepository() {
        this.map = new HashMap<>();
        this.id = 1L;
    }

    public Long addOrder(KitchenOrderDto kitchenDto) {
        map.put(this.id, kitchenDto);
        return id++;
    }

    public KitchenOrderDto updateOrder(Long id, KitchenOrderDto kitchenDto) {
        return map.put(id, kitchenDto);
    }

    public Map<Long, KitchenOrderDto> getOrders() {
        return map;
    }

    public KitchenOrderDto getOrder(Long id) {
        return map.get(id);
    }
}
