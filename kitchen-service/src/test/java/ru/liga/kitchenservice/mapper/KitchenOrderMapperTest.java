package ru.liga.kitchenservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.model.dto.enums.OrderStatus;
import ru.liga.kitchenservice.model.entity.KitchenOrder;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@SpringBootTest
public class KitchenOrderMapperTest {

    @Autowired
    private KitchenOrderMapper kitchenOrderMapper;

    @Test
    @DisplayName(value = "toDto: возвращает KitchenOrderDto, если KitchenOrder не равен null")
    void toDto_ReturnKitchenOrderDto_IfKitchenOrderIsNotNull() {
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
        KitchenOrderDto expected = KitchenOrderDto.builder()
                .kitchenOrderId(kitchenOrderId)
                .waiterOrderNo(waiterOrderNo)
                .status(orderStatus)
                .createDttm(createDttm)
                .build();

        // Действие
        KitchenOrderDto actual = kitchenOrderMapper.toDto(kitchenOrder);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toDto: возвращает null, если KitchenOrder равен null")
    void toDto_ReturnNull_IfKitchenOrderIsNull() {
        // Подготовка
        KitchenOrder kitchenOrder = null;
        KitchenOrderDto expected = null;

        // Действие
        KitchenOrderDto actual = kitchenOrderMapper.toDto(kitchenOrder);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toEntity: Возвращает KitchenOrder, если OrderFromWaiterDto не равен null")
    void toEntity_ReturnKitchenOrder_IfOrderFromWaiterDtoIsNotNull() {
        // Подготовка
        Long waiterOrderId = 1L;
        OrderStatus orderStatus = OrderStatus.NEW;
        OffsetDateTime createDttm = OffsetDateTime.now();
        OrderFromWaiterDto orderFromWaiterDto = OrderFromWaiterDto.builder()
                .waiterOrderNo(waiterOrderId)
                .status(orderStatus)
                .createDttm(createDttm)
                .positions(new ArrayList<>())
                .build();
        KitchenOrder expected = KitchenOrder.builder()
                .waiterOrderNo(waiterOrderId)
                .status(String.valueOf(orderStatus))
                .createDttm(createDttm)
                .build();

        // Действие
        KitchenOrder actual = kitchenOrderMapper.toEntity(orderFromWaiterDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toEntity: Возвращает null, если OrderFromWaiterDto равен null")
    void toEntity_ReturnNull_IfOrderFromWaiterDtoIsNull() {
        // Подготовка
        OrderFromWaiterDto orderFromWaiterDto = null;
        KitchenOrder expected = null;

        // Действие
        KitchenOrder actual = kitchenOrderMapper.toEntity(orderFromWaiterDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }


}
