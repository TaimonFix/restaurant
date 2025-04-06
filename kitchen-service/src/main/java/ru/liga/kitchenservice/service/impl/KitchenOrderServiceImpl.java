package ru.liga.kitchenservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.kitchenservice.mapper.KitchenOrderMapper;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.enums.Status;
import ru.liga.kitchenservice.model.entity.KitchenOrder;
import ru.liga.kitchenservice.repository.KitchenOrderRepository;
import ru.liga.kitchenservice.service.KitchenOrderService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenOrderServiceImpl implements KitchenOrderService {

    private final KitchenOrderRepository kitchenOrderRepository;
    private final KitchenOrderMapper kitchenOrderMapper;

    @Override
    public List<KitchenOrderDto> getOrders() {
        return kitchenOrderMapper.toDtoList(kitchenOrderRepository.findAll());
    }

    @Override
    public Long addOrder(KitchenOrderDto kitchenDto) {
        KitchenOrder order = kitchenOrderMapper.toEntity(kitchenDto);
        System.out.println(order.toString());
        return kitchenOrderRepository.save(order).getId();
    }

    /**
     * @throws NullPointerException если id заказа отсутствует в БД
     * @throws IllegalArgumentException если полученный status отсутствует в enum
     */
    @Override
    public KitchenOrderDto updateOrderStatus(Long id, String status) {
        try {
            String currentStatus = String.valueOf(Status.valueOf(status));
            KitchenOrder kitchenOrder = kitchenOrderRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("Заказ с id '" + id + "' отсутствует."));
            kitchenOrder.setStatus(currentStatus);
            return kitchenOrderMapper.toDto(kitchenOrderRepository.save(kitchenOrder));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Статус '" + status + "' отсутствует.");
        }
    }
}
