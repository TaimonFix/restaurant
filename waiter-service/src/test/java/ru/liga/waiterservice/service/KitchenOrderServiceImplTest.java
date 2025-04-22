package ru.liga.waiterservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.waiterservice.exception.OrderIsAlreadyInProcessingException;
import ru.liga.waiterservice.exception.OrderNotFoundException;
import ru.liga.waiterservice.kafka.producer.OrderProducer;
import ru.liga.waiterservice.mapper.KitchenOrderMapper;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.service.impl.KitchenOrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class KitchenOrderServiceImplTest {

    @Mock
    private OrderProducer orderProducer;

    @Mock
    private WaiterOrderService waiterOrderService;

    @Mock
    private OrderPositionsService orderPositionsService;

    @Mock
    private KitchenOrderMapper kitchenOrderMapper;

    @InjectMocks
    private KitchenOrderServiceImpl kitchenOrderService;

    @Test
    void postOrderToTheKitchen() {
        // Подготовка
        Long orderNo = 1L;
        WaiterOrderDto waiterOrderDto = WaiterOrderDto.builder()
                .status(OrderStatus.NEW)
                .orderNo(orderNo)
                .build();
        List<OrderPositionDto> orderPositionDtoList = new ArrayList<>();

        KitchenOrderDto kitchenOrderDto = new KitchenOrderDto();

        Mockito.when(waiterOrderService.getOrder(orderNo)).thenReturn(waiterOrderDto);
        Mockito.when(orderPositionsService.findOrderPositionsByOrderNo(orderNo)).thenReturn(orderPositionDtoList);
        Mockito.when(kitchenOrderMapper.toDto(waiterOrderDto, orderPositionDtoList)).thenReturn(kitchenOrderDto);

        kitchenOrderService.postOrderToTheKitchen(orderNo);
    }

    @Test
    void postOrderToTheKitchen_ThrowException_IfStatusNotNew() {
        // Подготовка
        Long orderNo = 1L;
        WaiterOrderDto waiterOrderDto = WaiterOrderDto.builder()
                .status(OrderStatus.APPROVED)
                .build();

        Mockito.when(waiterOrderService.getOrder(orderNo)).thenReturn(waiterOrderDto);
        Mockito.when(orderPositionsService.findOrderPositionsByOrderNo(orderNo)).thenReturn(null);

        // Действие
        Executable executable = () -> kitchenOrderService.postOrderToTheKitchen(orderNo);

        // Проверка
        Assertions.assertThrows(OrderIsAlreadyInProcessingException.class, executable);
    }
}
