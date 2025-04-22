package ru.liga.waiterservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.waiterservice.exception.OrderNotFoundException;
import ru.liga.waiterservice.mapper.WaiterOrderMapper;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.model.entity.WaiterOrderEntity;
import ru.liga.waiterservice.repository.WaiterOrderRepository;
import ru.liga.waiterservice.service.impl.WaiterOrderServiceImpl;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class WaiterOrderServiceImplTest {

    @Mock
    private WaiterOrderMapper waiterOrderMapper;

    @Mock
    private WaiterOrderRepository waiterOrderRepository;

    @Mock
    private OrderPositionsService orderPositionsService;

    @InjectMocks
    private WaiterOrderServiceImpl waiterOrderService;

    @Test
    void getOrders_ReturnWaiterOrderDtoList() {
        // Подготовка
        List<WaiterOrderDto> expected = new ArrayList<>();
        expected.add(new WaiterOrderDto());
        List<WaiterOrderEntity> waiterOrderEntityList = new ArrayList<>();
        waiterOrderEntityList.add(new WaiterOrderEntity());

        Mockito.when(waiterOrderRepository.getOrders()).thenReturn(waiterOrderEntityList);
        Mockito.when(waiterOrderService.getOrders()).thenReturn(expected);

        // Действие
        List<WaiterOrderDto> actual = waiterOrderService.getOrders();

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void saveOrder_ReturnOrderNo() {
        // Подготовка
        OrderDto orderDto = OrderDto.builder()
                .waiterId(1L)
                .tableNo("tableNo")
                .build();
        Long expected = 456L;
        WaiterOrderDto waiterOrderDto = WaiterOrderDto.builder()
                .waiterId(1L)
                .tableNo("tableNo")
                .build();
        WaiterOrderEntity waiterOrderEntity = new WaiterOrderEntity();

        Mockito.when(orderPositionsService.findOrderPositionsByOrderNo(1L)).thenReturn(null);
        Mockito.when(waiterOrderMapper.toDto(orderDto)).thenReturn(waiterOrderDto);
        Mockito.when(waiterOrderMapper.toEntity(waiterOrderDto)).thenReturn(waiterOrderEntity);
        Mockito.doAnswer(invocation -> {
            WaiterOrderEntity entity = invocation.getArgument(0);
            entity.setOrderNo(456L);
            return null;
        }).when(waiterOrderRepository).saveOrder(Mockito.any(WaiterOrderEntity.class));
        // Действие
        Long actual = waiterOrderService.saveOrder(orderDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getOrder_ReturnOrder_IfOrderExists() {
        // Подготовка
        Long orderNo = 456L;
        WaiterOrderDto expected = new WaiterOrderDto();
        WaiterOrderEntity waiterOrderEntity = new WaiterOrderEntity();
        expected.setOrderNo(orderNo);
        // Заказ существует
        Mockito.when(waiterOrderRepository.getOrder(orderNo)).thenReturn(waiterOrderEntity);
        Mockito.when(waiterOrderMapper.toDto(waiterOrderEntity)).thenReturn(expected);

        // Действие
        WaiterOrderDto actual = waiterOrderService.getOrder(orderNo);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getOrder_ThrowException_IfOrderDoesNotExist() {
        // Подготовка
        Long orderNo = 456L;

        // Заказ не существует
        Mockito.when(waiterOrderRepository.getOrder(orderNo)).thenReturn(null);

        // Действие
        Executable executable = () -> waiterOrderService.getOrderStatus(orderNo);

        // Проверка
        Assertions.assertThrows(OrderNotFoundException.class, executable);
    }

    @Test
    void getOrderStatus_ReturnOrderStatus_IfOrderExists() {
        // Подготовка
        Long orderNo = 456L;
        OrderStatus expected = OrderStatus.NEW;

        // Заказ существует
        Mockito.when(waiterOrderRepository.getOrder(orderNo)).thenReturn(new WaiterOrderEntity());
        // Заказ выдает статус
        Mockito.when(waiterOrderRepository.getStatus(orderNo)).thenReturn(expected);

        // Действие
        OrderStatus actual = waiterOrderService.getOrderStatus(orderNo);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getOrderStatus_ThrowException_IfOrderDoesNotExist() {
        // Подготовка
        Long orderNo = 456L;
        OrderStatus status = OrderStatus.NEW;

        // Заказ не существует
        Mockito.when(waiterOrderRepository.getOrder(orderNo)).thenReturn(null);

        // Действие
        Executable executable = () -> waiterOrderService.getOrderStatus(orderNo);

        // Проверка
        Assertions.assertThrows(OrderNotFoundException.class, executable);
    }

    @Test
    void updateOrder_ReturnOrderNo_IfOrderExists() {
        // Подготовка
        Long expected = 456L;
        WaiterOrderDto waiterOrderDto = new WaiterOrderDto();
        waiterOrderDto.setOrderNo(expected);
        WaiterOrderEntity waiterOrderEntity = new WaiterOrderEntity();
        waiterOrderEntity.setOrderNo(expected);

        // Заказ существует
        Mockito.when(waiterOrderRepository.getOrder(expected)).thenReturn(waiterOrderEntity);
        Mockito.when(waiterOrderMapper.toEntity(waiterOrderDto)).thenReturn(waiterOrderEntity);

        // Действие
        Long actual = waiterOrderService.updateOrder(waiterOrderDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void updateOrder_ReturnOrderNo_IfOrderDoesNotExists() {
        // Подготовка
        Long orderNo = 456L;
        WaiterOrderDto waiterOrderDto = new WaiterOrderDto();
        waiterOrderDto.setOrderNo(orderNo);

        // Заказ не существует
        Mockito.when(waiterOrderRepository.getOrder(orderNo)).thenReturn(null);
        String expectedMessage = "Заказ с номером '"+ orderNo +"' не найден";

        // Действие
        Executable executable = () -> waiterOrderService.updateOrder(waiterOrderDto);

        // Проверка
        OrderNotFoundException actualException = Assertions.assertThrows(OrderNotFoundException.class, executable);
        Assertions.assertEquals(expectedMessage, actualException.getMessage());
    }
}
