package ru.liga.kitchenservice.service;

import ru.liga.kitchenservice.model.dto.DishDto;

/**
 * Сервис для работы с блюдами на кухне.
 */
public interface DishService {

    /**
     * Получить блюдо по id.
     *
     * @param id блюда
     * @return {@link DishDto} блюдо
     */
    DishDto getDishDtoById(Long id);
}
