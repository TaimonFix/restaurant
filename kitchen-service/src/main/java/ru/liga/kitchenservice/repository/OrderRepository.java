package ru.liga.kitchenservice.repository;

import org.springframework.stereotype.Repository;
import ru.liga.kitchenservice.dto.KitchenDto;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
    private Map<Long, KitchenDto> map;
    private Long id;

    public OrderRepository() {
        this.map = new HashMap<>();
        this.id = 1L;
    }

    public KitchenDto addOrder(KitchenDto kitchenDto) {
        return map.put(this.id++, kitchenDto);
    }

    public KitchenDto updateOrder(Long id, KitchenDto kitchenDto) {
        return map.put(id, kitchenDto);
    }

    public Map<Long, KitchenDto> getOrders() {
        return map;
    }

    public KitchenDto getOrder(Long id) {
        return map.get(id);
    }
}
