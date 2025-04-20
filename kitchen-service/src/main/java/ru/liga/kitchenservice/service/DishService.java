package ru.liga.kitchenservice.service;

import ru.liga.kitchenservice.model.dto.DishDto;

import java.util.List;

/**
 * Сервис для работы с блюдами на кухне
 */
public interface DishService {

    /**
     * Получить блюдо по id
     *
     * @param id блюда
     * @return {@link DishDto} блюдо
     */
    DishDto getDishDtoById(Long id);

    /**
     * Метод, который проверяет, есть ли все блюда из списка на кухне
     *
     * @param dishDtoList список с блюдами
     * @return {@link Boolean} значение, true - есть, false - нет
     */
    Boolean isDishesAvailable(List<DishDto> dishDtoList);
}
