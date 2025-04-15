package ru.liga.waiterservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.waiterservice.exception.OrderIsAlreadyInProcessingException;
import ru.liga.waiterservice.kafka.producer.OrderProducer;
import ru.liga.waiterservice.mapper.KitchenOrderMapper;
import ru.liga.waiterservice.mapper.WaiterOrderMapper;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.service.KitchenOrderService;
import ru.liga.waiterservice.service.OrderPositionsService;
import ru.liga.waiterservice.service.WaiterOrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenOrderServiceImpl implements KitchenOrderService {

    private final WaiterOrderService waiterOrderService;
    private final OrderPositionsService orderPositionsService;
    private final OrderProducer orderProducer;
    private final KitchenOrderMapper kitchenOrderMapper;

    @Override
    public void postOrderToTheKitchen(Long id) {
        WaiterOrderDto waiterOrderDto = waiterOrderService.getOrder(id);
        List<OrderPositionDto> orderPositionDtoList =
                orderPositionsService.findOrderPositionsByOrderNo(id);
        if (orderPositionDtoList.isEmpty()) {
            throw new NullPointerException("В заказе отсутствуют позиции!");
        }
        if (waiterOrderDto.getStatus() != OrderStatus.NEW) {
            throw new OrderIsAlreadyInProcessingException();
        }
        waiterOrderDto.setStatus(OrderStatus.IN_PROCESSING);
        KitchenOrderDto kitchenOrderDto = kitchenOrderMapper.toDto(waiterOrderDto, orderPositionDtoList);
        waiterOrderService.updateOrder(waiterOrderDto);
        orderProducer.produce(kitchenOrderDto);
    }
}
