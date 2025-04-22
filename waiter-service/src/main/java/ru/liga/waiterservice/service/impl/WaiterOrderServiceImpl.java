package ru.liga.waiterservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.waiterservice.exception.OrderNotFoundException;
import ru.liga.waiterservice.mapper.WaiterOrderMapper;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.model.entity.WaiterOrderEntity;
import ru.liga.waiterservice.repository.WaiterOrderRepository;
import ru.liga.waiterservice.service.OrderPositionsService;
import ru.liga.waiterservice.service.WaiterOrderService;
import java.util.List;

/**
 * Реализация {@link WaiterOrderService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class WaiterOrderServiceImpl implements WaiterOrderService {

    private final WaiterOrderRepository waiterOrderRepository;
    private final WaiterOrderMapper waiterOrderMapper;
    private final OrderPositionsService orderPositionsService;

    /**
     * Получить все заказы.
     *
     * @return список {@link WaiterOrderDto} заказов
     */
    public List<WaiterOrderDto> getOrders() {
        log.info("Получение списка заказов");
        return waiterOrderMapper.toDtoList(waiterOrderRepository.getOrders());
    }

    /**
     * Получить заказ.
     *
     * @param id идентификатор заказа
     * @return {@link WaiterOrderDto} DTO заказа
     */
    public WaiterOrderDto getOrder(final Long id) {
        log.info("Получение заказа с номером '{}'", id);
        WaiterOrderEntity order = waiterOrderRepository.getOrder(id);
        if (order == null) {
            throw new OrderNotFoundException(id);
        }
        return waiterOrderMapper.toDto(order);
    }

    /**
     * Сохранить заказ.
     *
     * @param orderDto DTO заказа, который нужно сохранить
     * @return id сохраненного заказа
     */
    @Transactional
    public Long saveOrder(final OrderDto orderDto) {
        log.info("Сохранение заказа {}", orderDto);
        WaiterOrderEntity order = waiterOrderMapper
                .toEntity(waiterOrderMapper.toDto(orderDto));
        waiterOrderRepository.saveOrder(order);
        log.info("Заказ сохранен под номером '{}'", order.getOrderNo());
        orderPositionsService.saveOrderPositions(orderDto, order.getOrderNo());

        return order.getOrderNo();
    }

    /**
     * Получить статус заказа.
     *
     * @param id идентификатор заказа
     * @return {@link OrderStatus} статус заказа
     */
    public OrderStatus getOrderStatus(final Long id) {
        log.info("Получение статуса заказа с номером '{}'", id);
        if (waiterOrderRepository.getOrder(id) == null) {
            throw new OrderNotFoundException(id);
        }
        return waiterOrderRepository.getStatus(id);
    }

    /**
     * Обновить данные о заказе.
     *
     * @param waiterOrderDto DTO заказа, который нужно обновить
     * @return id обновленного заказа
     */
    public Long updateOrder(final WaiterOrderDto waiterOrderDto) {
        if (waiterOrderRepository.getOrder(waiterOrderDto.getOrderNo()) == null) {
            throw new OrderNotFoundException(waiterOrderDto.getOrderNo());
        }
        log.info("Обновление заказа с номером '{}'", waiterOrderDto.getOrderNo());
        WaiterOrderEntity order = waiterOrderMapper.toEntity(waiterOrderDto);
        waiterOrderRepository.updateOrder(order);
        log.info("Заказ с номером '{}' обновлен", waiterOrderDto.getOrderNo());
        return order.getOrderNo();
    }
}
