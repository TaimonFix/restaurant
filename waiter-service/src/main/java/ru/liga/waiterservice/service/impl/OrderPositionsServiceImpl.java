package ru.liga.waiterservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.waiterservice.mapper.OrderPositionMapper;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.entity.OrderPositionEntity;
import ru.liga.waiterservice.repository.OrderPositionsRepository;
import ru.liga.waiterservice.service.OrderPositionsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderPositionsServiceImpl implements OrderPositionsService {

    private final OrderPositionsRepository orderPositionsRepository;
    private final OrderPositionMapper orderPositionMapper;

    @Override
    public List<OrderPositionDto> findOrderPositionsByOrderNo(Long orderNo) {
        return orderPositionMapper.toDtoList(orderPositionsRepository.findByOrderNo(orderNo));
    }

    @Override
    public void saveOrderPositions(OrderDto orderDto) {
        Long orderNo = orderDto.getOrderNo();
        for (OrderPositionDto orderPositionDto: orderDto.getPositions()) {
            System.out.println(orderPositionDto);
            saveOrderPosition(orderPositionMapper.toEntity(orderPositionDto, orderNo));
        }
    }

    public void saveOrderPosition(OrderPositionEntity orderPositionEntity) {
        orderPositionsRepository.saveOrderPosition(orderPositionEntity);
    }
}
