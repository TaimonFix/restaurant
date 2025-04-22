package ru.liga.kitchenservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.service.DishInventoryService;
import ru.liga.kitchenservice.service.DishService;

import java.util.List;

/**
 * Реализация {@link DishInventoryService}.
 */
@Service
@RequiredArgsConstructor
public class DishInventoryServiceImpl implements DishInventoryService {

    private final DishService dishService;

    /**
     * Метод, который проверяет, есть ли все блюда из списка на кухне.
     *
     * @param dishDtoList список с блюдами
     * @return {@link Boolean} значение, true - есть, false - нет
     */
    @Override
    public Boolean isDishesAvailable(final List<DishDto> dishDtoList) {
        return !CollectionUtils.isEmpty(dishDtoList)
                && dishDtoList.stream().allMatch(dishNeeds -> {
                    DishDto dishStocks = dishService.getDishDtoById(dishNeeds.getMenuPositionId());
                    return dishStocks != null && isDishAvailable(dishStocks, dishNeeds);
                });
    }

    /**
     * Метод, который проверяет, есть ли необходимое блюдо для подачи на кухню.
     *
     * @param dishStocks запасы блюда на кухне
     * @param dishNeeds количество блюда, которое необходимо для подачи
     * @return {@link Boolean} значение, true - есть, false - нет
     */
    private Boolean isDishAvailable(final DishDto dishStocks,
                                   final DishDto dishNeeds) {
        return dishStocks.getDishNum() >= dishNeeds.getDishNum();
    }
}
