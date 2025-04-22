package ru.liga.kitchenservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.kitchenservice.exception.OrderNotFoundException;
import ru.liga.kitchenservice.feign.WaiterServiceFeignClient;
import ru.liga.kitchenservice.mapper.KitchenOrderMapper;
import ru.liga.kitchenservice.mapper.WaiterOrderMapper;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;
import ru.liga.kitchenservice.model.entity.KitchenOrder;
import ru.liga.kitchenservice.repository.KitchenOrderRepository;
import ru.liga.kitchenservice.service.DishInventoryService;
import ru.liga.kitchenservice.service.KitchenOrderService;
import java.util.List;

/**
 * Реализация {@link KitchenOrderService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class KitchenOrderServiceImpl implements KitchenOrderService {

    private final KitchenOrderRepository kitchenOrderRepository;
    private final DishInventoryService dishInventoryService;
    private final KitchenOrderMapper kitchenOrderMapper;
    private final WaiterServiceFeignClient waiterServiceFeignClient;
    private final WaiterOrderMapper waiterOrderMapper;

    /**
     * Получить все заказы.
     *
     * @return Список {@link KitchenOrderDto} заказов
     */
    @Override
    public List<KitchenOrderDto> getOrders() {
        log.info("Получение списка всех заказов");
        return kitchenOrderMapper.toDtoList(kitchenOrderRepository.findAll());
    }

    /**
     * Сохранить заказ в БД.
     *
     * @param orderFromWaiterDto заказ, присланный из сервиса официантов
     * @return {@link Long} id сформированного заказа
     */
    @Override
    @Transactional
    public Long saveOrder(final OrderFromWaiterDto orderFromWaiterDto) {
        List<DishDto> dishDtoList = orderFromWaiterDto.getPositions();
        if (!dishInventoryService.isDishesAvailable(dishDtoList)) {
            orderFromWaiterDto.setStatus(OrderStatus.REJECTED);
            log.info("Заказ с id '{}' отклонён", orderFromWaiterDto.getWaiterOrderNo());
        } else {
            orderFromWaiterDto.setStatus(OrderStatus.APPROVED);
            log.info("Заказ с id '{}' принят", orderFromWaiterDto.getWaiterOrderNo());
        }
        WaiterOrderDto waiterOrderDto = waiterOrderMapper.toWaiterOrderDto(orderFromWaiterDto);
        waiterServiceFeignClient.postOrder(waiterOrderDto);
        log.info("Информация о заказе отправлена в сервис официантов.");
        Long id = kitchenOrderRepository.save(kitchenOrderMapper.toEntity(orderFromWaiterDto)).getId();
        log.info("Заказ сохранен с id: '{}'", id);
        return id;
    }

    /**
     * Обновить статус заказа.
     *
     * @param id     идентификатор заказа
     * @param status обновленный статус
     * @throws OrderNotFoundException если id заказа отсутствует в БД
     * @throws IllegalArgumentException в случае, если полученный status отсутствует в enum
     */
    @Override
    @Transactional
    public void updateOrderStatus(final Long id, final String status) {
            String currentStatus = String.valueOf(OrderStatus.getStatusFromString(status));
            KitchenOrder kitchenOrder = kitchenOrderRepository.findById(id)
                    .orElseThrow(() -> new OrderNotFoundException(id));
            kitchenOrder.setStatus(currentStatus);
            WaiterOrderDto waiterOrderDto = waiterOrderMapper.toWaiterOrderDto(
                    kitchenOrderRepository.save(kitchenOrder));
            waiterServiceFeignClient.postOrder(waiterOrderDto);
        log.info("Статус заказа под номером '{}' обновлен на: '{}'", id, waiterOrderDto.getStatus());
    }
}
