package ru.liga.kitchenservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.kitchenservice.exception.DishNotFoundException;
import ru.liga.kitchenservice.mapper.DishMapper;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.repository.DishRepository;
import ru.liga.kitchenservice.service.DishService;

/**
 * Реализация {@link DishService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DishServiceImpl implements DishService {

    private final DishMapper dishMapper;
    private final DishRepository dishRepository;

    /**
     * Получить блюдо по id.
     *
     * @param id блюда
     * @return {@link DishDto} блюдо
     */
    @Override
    public DishDto getDishDtoById(final Long id) {
        log.info("Получение блюда с id: '{}'", id);
        return dishMapper.toDto(dishRepository.findById(id).orElseThrow(() -> new DishNotFoundException(id)));

    }
}
