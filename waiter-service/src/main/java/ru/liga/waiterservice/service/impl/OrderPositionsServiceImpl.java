package ru.liga.waiterservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.waiterservice.exception.OrderPositionsListIsEmptyException;
import ru.liga.waiterservice.mapper.OrderPositionMapper;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.entity.OrderPositionEntity;
import ru.liga.waiterservice.repository.OrderPositionsRepository;
import ru.liga.waiterservice.service.OrderPositionsService;

import java.util.List;

/**
 * Реализация {@link OrderPositionsService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderPositionsServiceImpl implements OrderPositionsService {

    private final OrderPositionsRepository orderPositionsRepository;
    private final OrderPositionMapper orderPositionMapper;

    /**
     * Получить все блюда из заказа.
     *
     * @param orderNo id заказа
     * @return Список {@link OrderPositionDto} блюд
     */
    @Override
    public List<OrderPositionDto> findOrderPositionsByOrderNo(final Long orderNo) {
        log.info("Получение списка позиций для заказа с номером '{}'", orderNo);
        List<OrderPositionEntity> orderPositionEntityList = orderPositionsRepository.findByOrderNo(orderNo);
        if (orderPositionEntityList == null || orderPositionEntityList.isEmpty()) {
            throw new OrderPositionsListIsEmptyException(orderNo);
        }
        return orderPositionMapper.toDtoList(orderPositionEntityList);
    }

    /**
     * Сохранить все позиции из заказа.
     *
     * @param orderDto информация о созданном заказе
     * @param orderNo номер заказа
     */
    @Override
    public void saveOrderPositions(final OrderDto orderDto, final Long orderNo) {
        if (orderDto.getPositions() == null || orderDto.getPositions().isEmpty()) {
            throw new OrderPositionsListIsEmptyException(orderNo);
        }
        log.info("Сохранение списка позиций для заказа с номером  '{}'", orderNo);
        for (OrderPositionDto orderPositionDto: orderDto.getPositions()) {
            saveOrderPosition(orderPositionMapper.toEntity(orderPositionDto, orderNo));
        }
    }

    /**
     * Сохранить позицию из заказа.
     *
     * @param orderPositionEntity Информация о количестве заказанных блюд.
     */
    private void saveOrderPosition(final OrderPositionEntity orderPositionEntity) {
        orderPositionsRepository.saveOrderPosition(orderPositionEntity);
        log.info("Сохранение позиции {}", orderPositionEntity);
    }
}
