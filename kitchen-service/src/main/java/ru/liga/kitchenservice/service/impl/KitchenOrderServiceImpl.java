package ru.liga.kitchenservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.kitchenservice.exception.OrderIsNotReadyException;
import ru.liga.kitchenservice.feign.WaiterServiceFeignClient;
import ru.liga.kitchenservice.mapper.DishMapper;
import ru.liga.kitchenservice.mapper.KitchenOrderMapper;
import ru.liga.kitchenservice.mapper.WaiterOrderMapper;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;
import ru.liga.kitchenservice.model.entity.KitchenOrder;
import ru.liga.kitchenservice.repository.KitchenOrderRepository;
import ru.liga.kitchenservice.service.DishService;
import ru.liga.kitchenservice.service.KitchenOrderService;
import java.util.List;

/**
 * Реализация {@link KitchenOrderService}
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class KitchenOrderServiceImpl implements KitchenOrderService {

    private final KitchenOrderRepository kitchenOrderRepository;
    private final DishService dishService;
    private final KitchenOrderMapper kitchenOrderMapper;
    private final WaiterServiceFeignClient waiterServiceFeignClient;
    private final WaiterOrderMapper waiterOrderMapper;

    @Override
    public List<KitchenOrderDto> getOrders() {
        return kitchenOrderMapper.toDtoList(kitchenOrderRepository.findAll());
    }

    @Override
    public Long saveOrder(KitchenOrderDto kitchenDto) {
        KitchenOrder order = kitchenOrderMapper.toEntity(kitchenDto);
        System.out.println(order.toString());
        return kitchenOrderRepository.save(order).getId();
    }

    @Override
    public Long saveOrder(OrderFromWaiterDto orderFromWaiterDto) {
        List<DishDto> dishDtoList = orderFromWaiterDto.getPositions();

        if (!dishService.isDishesAvailable(dishDtoList)) {
            orderFromWaiterDto.setStatus(OrderStatus.REJECTED);
            log.info("Заказ с id {} отклонён", orderFromWaiterDto.getWaiterOrderNo());
        } else {
            orderFromWaiterDto.setStatus(OrderStatus.APPROVED);
            log.info("Заказ с id {} принят", orderFromWaiterDto.getWaiterOrderNo());
        }
        WaiterOrderDto waiterOrderDto = waiterOrderMapper.toWaiterOrderDto(orderFromWaiterDto);
        waiterServiceFeignClient.postOrder(waiterOrderDto);

        return kitchenOrderRepository.save(kitchenOrderMapper.toEntity(orderFromWaiterDto)).getId();
    }

    /**
     * @throws NullPointerException если id заказа отсутствует в БД
     * @throws IllegalArgumentException если полученный status отсутствует в enum
     */
    @Override
    public KitchenOrderDto updateOrderStatus(Long id, String status) {
            String currentStatus = String.valueOf(OrderStatus.getStatusFromString(status));
            KitchenOrder kitchenOrder = kitchenOrderRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("Заказ с id '" + id + "' отсутствует."));
            kitchenOrder.setStatus(currentStatus);
            return kitchenOrderMapper.toDto(kitchenOrderRepository.save(kitchenOrder));
    }
    @Override
    public WaiterOrderDto getWaiterOrderDto(Long id) {
        WaiterOrderDto waiterOrderDto = toWaiterOrderDto(id);

        if (waiterOrderDto.getStatus() != OrderStatus.READY) {
            throw new OrderIsNotReadyException();
        }

        return waiterOrderDto;
    }

    public WaiterOrderDto toWaiterOrderDto(Long id) {
        KitchenOrder kitchenOrder = kitchenOrderRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Заказ с id '" + id + "' отсутствует."));
        return kitchenOrderMapper.toWaiterOrderDto(kitchenOrder);
    }
}
