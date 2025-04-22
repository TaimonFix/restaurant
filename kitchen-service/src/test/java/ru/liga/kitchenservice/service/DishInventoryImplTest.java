package ru.liga.kitchenservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.model.entity.Dish;
import ru.liga.kitchenservice.repository.DishRepository;
import ru.liga.kitchenservice.service.impl.DishInventoryServiceImpl;
import ru.liga.kitchenservice.service.impl.DishServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DishInventoryImplTest {

    @Mock
    private DishRepository dishRepository;

    @Mock
    private DishServiceImpl dishService;

    @InjectMocks
    private DishInventoryServiceImpl dishInventoryService;

    @Test
    @DisplayName(value = "isDishesAvailable: Возвращает false, если список с позициями равен null" +
            " или пуст")
    void isDishesAvailable_ReturnFalse_IfDishDtoListIsNullOrIsEmpty() {
        // Подготовка
        List<DishDto> positions1 = null;
        List<DishDto> positions2 = new ArrayList<>();
        boolean expected = false;

        // Действие
        boolean actual1 = dishInventoryService.isDishesAvailable(positions1);
        boolean actual2 = dishInventoryService.isDishesAvailable(positions2);

        // Проверка
        Assertions.assertEquals(expected, actual1);
        Assertions.assertEquals(expected, actual2);
    }
    @Test
    @DisplayName(value = "isDishesAvailable: Возвращает false, если заказанных позиций больше," +
            " чем есть на кухне")
    void isDishesAvailable_ReturnFalse_IfDishNeedsBiggerThanDishStocks() {
        // Подготовка
        List<DishDto> dishDtoList = List.of(new DishDto(1L, 3L));
        boolean expected = false;
        DishDto dishDto = DishDto.builder()
                .menuPositionId(1L)
                .dishNum(1L)
                .build();

        for (DishDto dishNeeds : dishDtoList) {
            Mockito.when(dishRepository.findById(dishNeeds.getMenuPositionId()))
                    .thenReturn(Optional.of(new Dish()));
            Mockito.when(dishService.getDishDtoById(dishNeeds.getMenuPositionId()))
                    .thenReturn(dishDto);
        }
        // Действие
        boolean actual = dishInventoryService.isDishesAvailable(dishDtoList);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(value = "isDishesAvailable: Возвращает true, если заказанных позиций <=," +
            " чем есть на кухне")
    void isDishesAvailable_ReturnTrue_IfDishNeedsLessThanDishStocks() {
        // Подготовка
        List<DishDto> dishDtoList = List.of(new DishDto(1L, 1L));
        boolean expected = true;
        DishDto dishDto = DishDto.builder()
                .menuPositionId(1L)
                .dishNum(3L)
                .build();

        for (DishDto dishNeeds : dishDtoList) {
            Mockito.when(dishRepository.findById(dishNeeds.getMenuPositionId()))
                    .thenReturn(Optional.of(new Dish()));
            Mockito.when(dishService.getDishDtoById(dishNeeds.getMenuPositionId()))
                    .thenReturn(dishDto);
        }
        // Действие
        boolean actual = dishInventoryService.isDishesAvailable(dishDtoList);

        // Проверка
        Assertions.assertEquals(expected, actual);
    }

}
