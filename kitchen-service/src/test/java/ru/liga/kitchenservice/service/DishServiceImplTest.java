package ru.liga.kitchenservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.kitchenservice.exception.DishNotFoundException;
import ru.liga.kitchenservice.mapper.DishMapper;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.model.entity.Dish;
import ru.liga.kitchenservice.repository.DishRepository;
import ru.liga.kitchenservice.service.impl.DishServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DishServiceImplTest {

    @Mock
    private DishRepository dishRepository;

    @Mock
    private DishMapper dishMapper;

    @InjectMocks
    private DishServiceImpl dishService;

    @Test
    @DisplayName(value = "getDishDtoById: Возвращает DishDto, если Dish присутствует в БД")
    void getDishDtoById_ReturnDishDto_IfDishExists() {
        // Подготовка
        Long id = 1L;
        DishDto expected = new DishDto();
        Dish dish = new Dish();
        Mockito.when(dishRepository.findById(id)).thenReturn(Optional.of(dish));
        Mockito.when(dishMapper.toDto(dish)).thenReturn(expected);

        // Действие
        DishDto actual = dishService.getDishDtoById(id);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "getDishDtoById: Возвращает Exception, если Dish отсутствует в БД")
    void getDishDtoById_ThrowException_IfDishDoesNotExists() {
        // Подготовка
        Long id = -1L;
        DishDto expected = new DishDto();
        Dish dish = new Dish();
        Mockito.when(dishRepository.findById(id)).thenThrow(new DishNotFoundException(id));
        Mockito.when(dishMapper.toDto(dish)).thenReturn(expected);

        // Действие
        Executable executable = () -> dishService.getDishDtoById(id);

        // Проверка
        Assertions.assertThrows(DishNotFoundException.class, executable);
    }
}

