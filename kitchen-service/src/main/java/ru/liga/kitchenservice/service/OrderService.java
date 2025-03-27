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

    /**
     * Получить все заказы
     */
    public Map<Long, KitchenDto> getOrders() {
        return orderRepository.getOrders();
    }

    /**
     * Добавить заказ
     * @Return id заказа
     */
    public Long addOrder(KitchenDto kitchenDto) {
        return orderRepository.addOrder(kitchenDto);
    }

    /**
     * Обновить статус заказа
     *
     * @Params id идентификатор заказа
     * @Params обновленный статус
     *
     * @throws IllegalArgumentException в случае, если полученный status отсутствует в enum
     */
    public KitchenDto updateOrderStatus(Long id, String status) {
        try {
            Status currentStatus = Status.valueOf(status);
            KitchenDto kitchenDto = orderRepository.getOrder(id);
            if (kitchenDto == null) {
                throw new NullPointerException("Заказ с id '" + id + "' отсутствует.");
            }
            kitchenDto.setStatus(currentStatus);
            return orderRepository.updateOrder(id, kitchenDto);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Статус '" + status + "' отсутствует.");
        }
    }
}
