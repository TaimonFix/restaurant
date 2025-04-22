package ru.liga.kitchenservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;
import ru.liga.kitchenservice.model.entity.KitchenOrder;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@SpringBootTest
public class WaiterOrderMapperTest {

    @Autowired
    private WaiterOrderMapper waiterOrderMapper;

    @Test
    @DisplayName(value = "toWaiterOrderDto: Возвращает WaiterOrderDto, если OrderFromWaiterDto" +
            " не равен null")
    void toWaiterOrderDto_ReturnWaiterOrderDto_IfOrderFromWaiterDtoIsNotNull() {
        // Подготовка
        Long waiterOrderNo = 1L;
        OrderStatus orderStatus = OrderStatus.NEW;
        OffsetDateTime createDttm = OffsetDateTime.now();
        OrderFromWaiterDto orderFromWaiterDto = OrderFromWaiterDto.builder()
                .waiterOrderNo(waiterOrderNo)
                .status(orderStatus)
                .createDttm(createDttm)
                .positions(new ArrayList<>())
                .build();
        WaiterOrderDto expected = WaiterOrderDto.builder()
                .orderNo(waiterOrderNo)
                .status(orderStatus)
                .createDttm(createDttm)
                .build();

        // Действие
        WaiterOrderDto actual = waiterOrderMapper.toWaiterOrderDto(orderFromWaiterDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toWaiterOrderDto: Возвращает null, если OrderFromWaiterDto" +
            " равен null")
    void toWaiterOrderDto_ReturnNull_IfOrderFromWaiterDtoIsNull() {
        // Подготовка
        OrderFromWaiterDto orderFromWaiterDto = null;
        WaiterOrderDto expected = null;

        // Действие
        WaiterOrderDto actual = waiterOrderMapper.toWaiterOrderDto(orderFromWaiterDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toWaiterOrderDto: возвращает WaiterOrderDto, если KitchenOrder не равен null")
    void toWaiterOrderDto_ReturnWaiterOrderDto_IfKitchenOrderIsNotNull() {
        // Подготовка
        Long kitchenOrderId = 1L;
        Long waiterOrderNo = 1L;
        OrderStatus orderStatus = OrderStatus.NEW;
        OffsetDateTime createDttm = OffsetDateTime.now();

        KitchenOrder kitchenOrder = KitchenOrder.builder()
                .id(kitchenOrderId)
                .waiterOrderNo(waiterOrderNo)
                .status(String.valueOf(orderStatus))
                .createDttm(createDttm)
                .build();
        WaiterOrderDto expected = WaiterOrderDto.builder()
                .orderNo(waiterOrderNo)
                .status(orderStatus)
                .createDttm(createDttm)
                .build();

        // Действие
        WaiterOrderDto actual = waiterOrderMapper.toWaiterOrderDto(kitchenOrder);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toWaiterOrderDto: возвращает null, если KitchenOrder равен null")
    void toWaiterOrderDto_ReturnNull_IfKitchenOrderIsNull() {
        // Подготовка
        KitchenOrder kitchenOrder = null;
        WaiterOrderDto expected = null;

        // Действие
        WaiterOrderDto actual = waiterOrderMapper.toWaiterOrderDto(kitchenOrder);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }
}
