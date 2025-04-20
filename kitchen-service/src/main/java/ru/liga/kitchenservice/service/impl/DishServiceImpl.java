package ru.liga.kitchenservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.kitchenservice.mapper.DishMapper;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.repository.DishRepository;
import ru.liga.kitchenservice.service.DishService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishMapper dishMapper;
    private final DishRepository dishRepository;

    @Override
    public DishDto getDishDtoById(Long id){
        return dishMapper.toDto(dishRepository.findById(id).orElse(null));
    }

    public Boolean isDishesAvailable(List<DishDto> dishDtoList) {
        DishDto dishStocks;
        for (DishDto dishNeeds : dishDtoList){
            dishStocks = getDishDtoById(dishNeeds.getMenuPositionId());
            if (dishStocks == null) {
                return false;
            }
            if (!isDishAvailable(dishStocks, dishNeeds)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод, который проверяет, есть ли необходимое блюдо для подачи на кухню
     *
     * @param dishStocks запасы блюда на кухне
     * @param dishNeeds количество блюда, которое необходимо для подачи
     * @return {@link Boolean} значение, true - есть, false - нет
     */
    public Boolean isDishAvailable(DishDto dishStocks, DishDto dishNeeds) {
        return dishStocks.getDishNum() >= dishNeeds.getDishNum();
    }
}
