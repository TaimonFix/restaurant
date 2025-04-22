package ru.liga.kitchenservice.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.model.entity.Dish;

@SpringBootTest
public class DishMapperTest {

    @Autowired
    private DishMapper dishMapper;

    @Test
    @DisplayName(value = "toDto: возвращает DishDto, если Dish не равен null")
    void toDto_ReturnDishDto_IfDishIsNotNull() {
        // Подготовка
        Dish dish = Dish.builder()
                .id(1L)
                .balance(1L)
                .build();
        DishDto expected = DishDto.builder()
                .dishNum(1L)
                .menuPositionId(1L)
                .build();

        // Действие
        DishDto actual = dishMapper.toDto(dish);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "toDto: возвращает null, если Dish равен null")
    void toDto_ReturnNull_IfDishIsNull() {
        // Подготовка
        Dish dish = null;
        DishDto expected = null;

        // Действие
        DishDto actual = dishMapper.toDto(dish);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }
}
