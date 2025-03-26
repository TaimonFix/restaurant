package ru.liga.waiterservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.waiterservice.dto.OrderDto;
import ru.liga.waiterservice.dto.enums.Status;
import ru.liga.waiterservice.repository.OrderRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    /**
     * Получить все заказы
     */
    public Map<Long, OrderDto> getOrders() {
        if (orderRepository.getOrders().isEmpty()) {
            throw new NullPointerException("В базе данных нет заказов.");
        }
        return orderRepository.getOrders();
    }

    /**
     * Получить заказ
     * @param id идентификатор заказа
     */
    public OrderDto getOrder(Long id) {
        if (orderRepository.getOrder(id) == null) {
            throw new NullPointerException("Заказ с id '"+ id + "' отсутствует.");
        }
            return orderRepository.getOrder(id);
    }

    /**
     * Добавить заказ
     */
    public OrderDto addOrder(OrderDto orderDto) {
        return orderRepository.addOrder(orderDto);
    }

    /**
     * Получить статус заказа
     * @param id идентификатор заказа
     */
    public Status getStatus(Long id) {
        if (orderRepository.getOrder(id) == null) {
            throw new NullPointerException("Заказ с id '"+ id + "' отсутствует.");
        }
        return orderRepository.getStatus(id);
    }
}
