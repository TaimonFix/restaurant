package ru.liga.kitchenservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.model.entity.Dish;

/**
 * Маппер для работы с блюдами на кухне
 */
@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(target = "menuPositionId", source = "id")
    @Mapping(target = "dishNum", source = "balance")
    DishDto toDto(Dish dish);



}
