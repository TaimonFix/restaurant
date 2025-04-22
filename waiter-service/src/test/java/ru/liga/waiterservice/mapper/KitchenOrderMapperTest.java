package ru.liga.waiterservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class KitchenOrderMapperTest {

    @Autowired
    private KitchenOrderMapper kitchenOrderMapper;

    @Test
    @DisplayName("toDto: вернуть KitchenOrderDto, если WaiterOrderDto и список позиций OrderPositionDto" +
            " не равны null")
    void toDto_ReturnKitchenOrderDto_IfWaiterOrderDtoIsNotNullAndPositionsIsNotNull() {
        // Подготовка
        // Значению по умолчанию даты
        OffsetDateTime defaultDateTime = OffsetDateTime.now();
        List<OrderPositionDto> positions = new ArrayList<>();
        WaiterOrderDto waiterOrderDto = WaiterOrderDto.builder()
                .status(OrderStatus.NEW)
                .createDttm(defaultDateTime)
                .tableNo("tableNo")
                .build();
        KitchenOrderDto expected = KitchenOrderDto.builder()
                .status(OrderStatus.NEW)
                .createDttm(defaultDateTime)
                .positions(positions)
                .build();
        // Действие
        KitchenOrderDto actual = kitchenOrderMapper.toDto(waiterOrderDto, positions);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toDto: вернуть null, если WaiterOrderDto и список позиций OrderPositionDto" +
            " равны null")
    void toDto_ReturnKitchenOrderDto_IfWaiterOrderDtoIsNullAndPositionsIsNull() {
        // Подготовка
        List<OrderPositionDto> positions = null;
        WaiterOrderDto waiterOrderDto = null;
        KitchenOrderDto expected = null;
        // Действие
        KitchenOrderDto actual = kitchenOrderMapper.toDto(waiterOrderDto, positions);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toDto: вернуть KitchenOrderDto, если WaiterOrderDto равен null, а список позиций OrderPositionDto" +
            " не равен null")
    void toDto_ReturnKitchenOrderDto_IfWaiterOrderDtoIsNullAndPositionsIsNotNull() {
        // Подготовка
        List<OrderPositionDto> positions = new ArrayList<>();
        WaiterOrderDto waiterOrderDto = null;
        KitchenOrderDto expected = KitchenOrderDto.builder()
                .positions(positions)
                .build();
        // Действие
        KitchenOrderDto actual = kitchenOrderMapper.toDto(waiterOrderDto, positions);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toDto: вернуть KitchenOrderDto, если WaiterOrderDto не равен null, а список позиций OrderPositionDto" +
            " равен null")
    void toDto_ReturnKitchenOrderDto_IfWaiterOrderDtoIsNotNullAndPositionsIsNull() {
        // Подготовка
        // Значению по умолчанию даты
        OffsetDateTime defaultDateTime = OffsetDateTime.now();
        List<OrderPositionDto> positions = null;
        WaiterOrderDto waiterOrderDto = WaiterOrderDto.builder()
                .status(OrderStatus.NEW)
                .createDttm(defaultDateTime)
                .tableNo("tableNo")
                .build();
        KitchenOrderDto expected = KitchenOrderDto.builder()
                .status(OrderStatus.NEW)
                .createDttm(defaultDateTime)
                .positions(positions)
                .build();
        // Действие
        KitchenOrderDto actual = kitchenOrderMapper.toDto(waiterOrderDto, positions);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }
}
