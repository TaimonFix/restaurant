package ru.liga.kitchenservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.kitchenservice.dto.KitchenDto;
import ru.liga.kitchenservice.dto.enums.Status;
import ru.liga.kitchenservice.repository.OrderRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Map<Long, KitchenDto> getOrders() {
        if (orderRepository.getOrders().isEmpty()) {
            throw new NullPointerException("В базе данных нет заказов.");
        }
        return orderRepository.getOrders();
    }

    public KitchenDto addOrder(KitchenDto kitchenDto) {
        return orderRepository.addOrder(kitchenDto);
    }

    public KitchenDto updateOrderStatus(Long id, String status) {
        try {
            Status status1 = Status.valueOf(status);
            KitchenDto kitchenDto = orderRepository.getOrder(id);
            if (kitchenDto == null) {
                throw new NullPointerException("Заказ с id '" + id + "' отсутствует.");
            }
            kitchenDto.setStatus(status1);
            return orderRepository.updateOrder(id, kitchenDto);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Статус '" + status + "' отсутствует. (см. dto.enums.Status)");
        }
    }
}
