package ru.liga.waiterservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.model.entity.WaiterOrderEntity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class WaiterOrderMapperTest {

    @Autowired
    private WaiterOrderMapper waiterOrderMapper;

    @Test
    @DisplayName(value = "toDto: возвращает WaiterOrderDto, если WaiterOrderEntity не равен null")
    void toDto_ReturnWaiterOrderDto_IfWaiterOrderEntityIsNotNull() {
        // Подготовка
        WaiterOrderDto expected = WaiterOrderDto.builder()
                .orderNo(1L)
                .status(OrderStatus.NEW)
                .waiterId(1L)
                .tableNo("tableNo")
                .createDttm(OffsetDateTime.parse("2025-04-17T08:26:11.890Z"))
                .build();

        WaiterOrderEntity waiterOrderEntity = WaiterOrderEntity.builder()
                .orderNo(1L)
                .status(OrderStatus.NEW)
                .waiterId(1L)
                .tableNo("tableNo")
                .createDttm(OffsetDateTime.parse("2025-04-17T08:26:11.890Z"))
                .build();

        // Действие
        WaiterOrderDto actual = waiterOrderMapper.toDto(waiterOrderEntity);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toDto: возвращает null, если WaiterOrderEntity равен null")
    void toDto_ReturnNull_IfWaiterOrderEntityIsNull() {
        // Подготовка
        WaiterOrderDto expected = null;
        WaiterOrderEntity waiterOrderEntity = null;
        // Действие
        WaiterOrderDto actual = waiterOrderMapper.toDto(waiterOrderEntity);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toEntity: возвращает WaiterOrderEntity, если WaiterOrderDto не равен null")
    void toEntity_ReturnWaiterOrderEntity_IfWaiterOrderDtoIsNotNull() {
        // Подготовка
        WaiterOrderEntity expected = WaiterOrderEntity.builder()
                .orderNo(1L)
                .status(OrderStatus.NEW)
                .waiterId(1L)
                .tableNo("tableNo")
                .createDttm(OffsetDateTime.parse("2025-04-17T08:26:11.890Z"))
                .build();

        WaiterOrderDto waiterOrderDto = WaiterOrderDto.builder()
                .orderNo(1L)
                .status(OrderStatus.NEW)
                .waiterId(1L)
                .tableNo("tableNo")
                .createDttm(OffsetDateTime.parse("2025-04-17T08:26:11.890Z"))
                .build();

        // Действие
        WaiterOrderEntity actual = waiterOrderMapper.toEntity(waiterOrderDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toEntity: возвращает null, если WaiterOrderDto равен null")
    void toEntity_ReturnNull_IfWaiterOrderDtoIsNull() {
        // Подготовка
        WaiterOrderEntity expected = null;
        WaiterOrderDto waiterOrderDto = null;
        // Действие
        WaiterOrderEntity actual = waiterOrderMapper.toEntity(waiterOrderDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toEntity: возвращает WaiterOrderDto, если OrderDto не равен null")
    void toDto_ReturnWaiterOrderDto_IfOrderDtoIsNotNull() {

        // Значению по умолчанию даты
        OffsetDateTime defaultDateTime = OffsetDateTime.now();
        // Подготовка
        WaiterOrderDto expected = WaiterOrderDto.builder()
                .waiterId(1L)
                .tableNo("tableNo")
                .createDttm(defaultDateTime)
                .build();

        OrderDto orderDto = OrderDto.builder()
                .waiterId(1L)
                .tableNo("tableNo")
                .build();

        // Действие
        WaiterOrderDto actual = waiterOrderMapper.toDto(orderDto);
        actual.setCreateDttm(defaultDateTime);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toDto: возвращает null, если OrderDto равен null")
    void toDto_ReturnNull_IfOrderDtoIsNull() {
        // Подготовка
        WaiterOrderDto expected = null;

        OrderDto orderDto = null;

        // Действие
        WaiterOrderDto actual = waiterOrderMapper.toDto(orderDto);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toDtoList: возвращает список WaiterOrderDto, если список " +
            "WaiterOrderEntity не равен null")
    void toDtoList_ReturnWaiterOrderDtoList_IfWaiterOrderEntityListIsNotNull() {
        // Подготовка
        List<WaiterOrderEntity> waiterOrderEntityList = new ArrayList<>();
        List<WaiterOrderDto> expected = new ArrayList<>();

        // Действие
        List<WaiterOrderDto> actual = waiterOrderMapper.toDtoList(waiterOrderEntityList);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toDtoList: возвращает список WaiterOrderDto, если список " +
            "WaiterOrderEntity не  null")
    void toDtoList_ReturnWaiterOrderDtoList_IfWaiterOrderEntityListIsNull() {
        // Подготовка
        List<WaiterOrderEntity> waiterOrderEntityList = null;
        List<WaiterOrderDto> expected = null;

        // Действие
        List<WaiterOrderDto> actual = waiterOrderMapper.toDtoList(waiterOrderEntityList);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }
}
