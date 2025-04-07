package ru.liga.waiterservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.Status;
import ru.liga.waiterservice.mapper.WaiterOrderMapper;
import ru.liga.waiterservice.service.WaiterOrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WaiterOrderServiceImpl implements WaiterOrderService {
    private final WaiterOrderMapper waiterOrderMapper;

    public List<WaiterOrderDto> getOrders() {
        return waiterOrderMapper.getOrders();
    }

    public WaiterOrderDto getOrder(Long id) {
        if (waiterOrderMapper.getOrder(id) == null) {
            throw new NullPointerException("Заказ с id '" + id + "' отсутствует.");
        }
        return waiterOrderMapper.getOrder(id);
    }

    public Long addOrder(WaiterOrderDto orderDto) {
        return waiterOrderMapper.addOrder(orderDto);
    }

    public Status getStatus(Long id) {
        if (waiterOrderMapper.getOrder(id) == null) {
            throw new NullPointerException("Заказ с id '" + id + "' отсутствует.");
        }
        return waiterOrderMapper.getStatus(id);
    }
}
