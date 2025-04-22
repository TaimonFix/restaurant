package ru.liga.waiterservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.waiterservice.exception.OrderIsAlreadyInProcessingException;
import ru.liga.waiterservice.kafka.producer.OrderProducer;
import ru.liga.waiterservice.mapper.KitchenOrderMapper;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.service.KitchenOrderService;
import ru.liga.waiterservice.service.OrderPositionsService;
import ru.liga.waiterservice.service.WaiterOrderService;

import java.util.List;

/**
 * Реализация {@link KitchenOrderService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class KitchenOrderServiceImpl implements KitchenOrderService {

    private final WaiterOrderService waiterOrderService;
    private final OrderPositionsService orderPositionsService;
    private final OrderProducer orderProducer;
    private final KitchenOrderMapper kitchenOrderMapper;

    /**
     * Отправить заказ на кухню.
     *
     * @param id идентификатор заказа
     */
    @Override
    @Transactional
    public void postOrderToTheKitchen(final Long id) {
        log.info("Сбор данных о заказе '{}' для отправки на кухню", id);
        WaiterOrderDto waiterOrderDto = waiterOrderService.getOrder(id);
        List<OrderPositionDto> orderPositionDtoList = orderPositionsService.findOrderPositionsByOrderNo(id);
        if (waiterOrderDto.getStatus() != OrderStatus.NEW) {
            throw new OrderIsAlreadyInProcessingException(id);
        }
        waiterOrderDto.setStatus(OrderStatus.IN_PROCESSING);
        KitchenOrderDto kitchenOrderDto = kitchenOrderMapper.toDto(waiterOrderDto, orderPositionDtoList);
        waiterOrderService.updateOrder(waiterOrderDto);
        log.info("Статус заказа с номером '{}' изменен на '{}'", id, waiterOrderDto.getStatus());
        orderProducer.produce(kitchenOrderDto);
        log.info("Заказ с номером '{}' отправлен на кухню. Состав заказа {}", id, kitchenOrderDto);
    }
}
