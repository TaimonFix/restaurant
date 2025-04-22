package ru.liga.waiterservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.waiterservice.model.dto.OrderPositionDto;
import ru.liga.waiterservice.model.entity.OrderPositionEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderPositionMapperTest {

    @Autowired
    private OrderPositionMapper orderPositionMapper;

    @Test
    @DisplayName("toEntity: возвращает OrderPositionEntity, если OrderPositionDto и orderNo " +
            "не равны null")
    void toEntity_ReturnOrderPositionEntity_IfOrderPositionDtoIsNotNullAndOrderNoIsNotNull() {
        // Подготовка
        Long orderNo = 1L;
        OrderPositionDto orderPositionDto = OrderPositionDto.builder()
                .menuPositionId(1L)
                .dishNum(1L)
                .build();
        OrderPositionEntity expected = OrderPositionEntity.builder()
                .orderNo(orderNo)
                .menuPositionId(1L)
                .dishNum(1L)
                .build();

        // Действие
        OrderPositionEntity actual = orderPositionMapper.toEntity(orderPositionDto, orderNo);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toEntity: возвращает null, если OrderPositionDto и orderNo " +
            "равны null")
    void toEntity_ReturnNull_IfOrderPositionDtoIsNullAndOrderNoIsNull() {
        // Подготовка
        Long orderNo = null;
        OrderPositionDto orderPositionDto = null;
        OrderPositionEntity expected = null;

        // Действие
        OrderPositionEntity actual = orderPositionMapper.toEntity(orderPositionDto, orderNo);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toEntity: возвращает OrderPositionEntity," +
            " если OrderPositionDto равен null, а orderNo не равен null")
    void toEntity_ReturnOrderPositionEntity_IfOrderPositionDtoIsNullAndOrderNoIsNotNull() {
        // Подготовка
        Long orderNo = 1L;
        OrderPositionDto orderPositionDto = null;
        OrderPositionEntity expected = OrderPositionEntity.builder()
                .orderNo(orderNo).build();

        // Действие
        OrderPositionEntity actual = orderPositionMapper.toEntity(orderPositionDto, orderNo);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toEntity: возвращает OrderPositionEntity, если OrderPositionDto не равен null, а" +
            " orderNo равен null")
    void toEntity_ReturnOrderPositionEntity_IfOrderPositionDtoIsNotNullAndOrderNoIsNull() {
        // Подготовка
        Long orderNo = null;
        OrderPositionDto orderPositionDto = OrderPositionDto.builder()
                .menuPositionId(1L)
                .dishNum(1L)
                .build();
        OrderPositionEntity expected = OrderPositionEntity.builder()
                .orderNo(orderNo)
                .menuPositionId(1L)
                .dishNum(1L)
                .build();

        // Действие
        OrderPositionEntity actual = orderPositionMapper.toEntity(orderPositionDto, orderNo);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toDtoList: вернуть список OrderPositionDto, если список OrderPositionEntity" +
            " не равен null")
    void toDtoList_ReturnOrderPositionDtoList_IfOrderPositionEntityListIsNotNull() {
        // Подготовка
        List<OrderPositionEntity> orderPositionEntityList = new ArrayList<>();
        List<OrderPositionDto> expected = new ArrayList<>();

        // Действие
        List<OrderPositionDto> actual = orderPositionMapper.toDtoList(orderPositionEntityList);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toDtoList: вернуть null, если список OrderPositionEntity" +
            " равен null")
    void toDtoList_ReturnOrderPositionDtoList_IfOrderPositionEntityListIsNull() {
        // Подготовка
        List<OrderPositionEntity> orderPositionEntityList = null;
        List<OrderPositionDto> expected = null;

        // Действие
        List<OrderPositionDto> actual = orderPositionMapper.toDtoList(orderPositionEntityList);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }
}
