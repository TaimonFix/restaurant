package ru.liga.waiterservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.waiterservice.exception.OrderNotFoundException;
import ru.liga.waiterservice.exception.OrderPositionsListIsEmptyException;
import ru.liga.waiterservice.mapper.OrderPositionMapper;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.entity.OrderPositionEntity;
import ru.liga.waiterservice.repository.OrderPositionsRepository;
import ru.liga.waiterservice.service.impl.OrderPositionsServiceImpl;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderPositionsServiceImplTest {

    @Mock
    private OrderPositionMapper orderPositionMapper;

    @Mock
    private OrderPositionsRepository orderPositionsRepository;

    @InjectMocks
    private OrderPositionsServiceImpl orderPositionsService;

    @Test
    void findOrderPositionsByOrderNo_ReturnListOfOrderPositionDto_IfOrderPositionsExist() {
        // Подготовка
        Long orderNo = 1L;
        List<OrderPositionDto> expected = new ArrayList<>();
        expected.add(new OrderPositionDto());
        List<OrderPositionEntity> orderPositionEntityList = new ArrayList<>();
        orderPositionEntityList.add(new OrderPositionEntity());

        Mockito.when(orderPositionsRepository.findByOrderNo(orderNo)).thenReturn(orderPositionEntityList);
        Mockito.when(orderPositionsService.findOrderPositionsByOrderNo(orderNo)).thenReturn(expected);

        // Действие
        List<OrderPositionDto> actual = orderPositionsService.findOrderPositionsByOrderNo(orderNo);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findOrderPositionsByOrderNo_ThrowException_IfOrderPositionsDoesNotExist() {
        // Подготовка
        Long orderNo = 1L;

        Mockito.when(orderPositionsRepository.findByOrderNo(orderNo)).thenReturn(null);

        // Действие
        Executable executable = () -> orderPositionsService.findOrderPositionsByOrderNo(orderNo);

        // Проверка
        Assertions.assertThrows(OrderPositionsListIsEmptyException.class, executable);
    }

    @Test
    void saveOrderPositions() {
        // Подготовка
        OrderDto orderDto = new OrderDto();
        List<OrderPositionDto> orderPositionDtos = new ArrayList<>();
        OrderPositionDto orderPositionDto = new OrderPositionDto();
        orderPositionDto.setMenuPositionId(1L);
        orderPositionDto.setDishNum(1L);
        orderPositionDtos.add(orderPositionDto);
        orderDto.setPositions(orderPositionDtos);
        Long orderNo = 1L;
        orderPositionsService.saveOrderPositions(orderDto, orderNo);
    }

    @Test
    void saveOrderPositions_ThrowException_IfOrderPositionsListIsEmpty() {
        // Подготовка
        OrderDto orderDto = new OrderDto();
        Long orderNo = 1L;
        String expectedMessage = "В заказе c номером '"+ orderNo + "' отсутствуют позиции с блюдами!";
        // Действие
        Executable executable = () -> orderPositionsService.saveOrderPositions(orderDto, orderNo);

        // Проверка
        Assertions.assertThrows(OrderPositionsListIsEmptyException.class, executable);
    }
}
