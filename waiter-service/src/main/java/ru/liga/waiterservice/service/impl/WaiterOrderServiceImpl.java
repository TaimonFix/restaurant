package ru.liga.waiterservice.service.impl;

import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.waiterservice.mapper.WaiterOrderMapper;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.model.entity.WaiterOrderEntity;
import ru.liga.waiterservice.kafka.producer.OrderProducer;
import ru.liga.waiterservice.repository.WaiterOrderRepository;
import ru.liga.waiterservice.service.WaiterOrderService;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Реализация {@link WaiterOrderService}
 */
@Service
@RequiredArgsConstructor
public class WaiterOrderServiceImpl implements WaiterOrderService {
    private final WaiterOrderRepository waiterOrderRepository;
    private final WaiterOrderMapper waiterOrderMapper;
    private final OrderProducer orderProducer;
    private final ProcessorMetrics processorMetrics;

    public List<WaiterOrderDto> getOrders() {
        return waiterOrderMapper.toDtoList(waiterOrderRepository.getOrders());
    }

    public WaiterOrderDto getOrder(Long id) {
        WaiterOrderEntity order = waiterOrderRepository.getOrder(id);
        if (order == null) {
            throw new NullPointerException("Заказ с id '" + id + "' отсутствует.");
        }
        return waiterOrderMapper.toDto(order);
    }

    public Long saveOrder(WaiterOrderDto orderDto) {
        if (orderDto.getCreateDttm() == null) {
            orderDto.setCreateDttm(OffsetDateTime.now());
        }
        WaiterOrderEntity order = waiterOrderMapper.toEntity(orderDto);
        waiterOrderRepository.saveOrder(order);
        return order.getOrderNo();
    }

    public OrderStatus getOrderStatus(Long id) {
        if (waiterOrderRepository.getOrder(id) == null) {
            throw new NullPointerException("Заказ с id '" + id + "' отсутствует.");
        }
        return waiterOrderRepository.getStatus(id);
    }

    public Long updateOrder(WaiterOrderDto orderDto) {
        WaiterOrderEntity order = waiterOrderMapper.toEntity(orderDto);
        waiterOrderRepository.updateOrder(order);
        return order.getOrderNo();
    }
//
//    public KitchenOrderDto toKitchenOrderDto(Long id) {
//        WaiterOrderEntity order = waiterOrderRepository.getOrder(id);
//        if (order == null) {
//            throw new NullPointerException("Заказ с id '" + id + "' отсутствует.");
//        }
//        return waiterOrderMapper.toKitchenOrderDto(order);
//    }

    public void postOrderToTheKitchen(Long id) {
        WaiterOrderDto waiterOrderDto = getOrder(id);
        KitchenOrderDto kitchenOrderDto = waiterOrderMapper.toKitchenOrderDto(waiterOrderDto);
        orderProducer.produce(kitchenOrderDto);
    }
}
