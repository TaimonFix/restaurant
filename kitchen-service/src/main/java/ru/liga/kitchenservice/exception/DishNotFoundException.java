package ru.liga.kitchenservice.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Исключение, возникающее в случае,
 * если позиция отсутствует в БД.
 */
@Slf4j
public class DishNotFoundException extends RuntimeException {

    /**
     * Позиция не найдена.
     *
     * @param id идентификатор блюда в БД
     */
    public DishNotFoundException(final Long id) {
        super("Блюдо с id: '" + id + "' отсутствует");
        log.warn("Блюдо с id: '{}' отсутствует", id);
    }
}
