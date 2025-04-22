package ru.liga.kitchenservice.service;

import ru.liga.kitchenservice.model.dto.DishDto;

import java.util.List;

/**
 * Сервис для проверки наличия позиций на кухне.
 */
public interface DishInventoryService {

    /**
     * Метод, который проверяет, есть ли все блюда из списка на кухне.
     *
     * @param dishDtoList список с блюдами
     * @return {@link Boolean} значение, true - есть, false - нет
     */
    Boolean isDishesAvailable(List<DishDto> dishDtoList);

}
