package ru.liga.kitchenservice.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.kitchenservice.model.dto.DishDto;
import ru.liga.kitchenservice.model.entity.Dish;

/**
 * Маппер для работы с блюдами на кухне.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DishMapper {

    /**
     * Маппинг: {@link Dish} -> {@link DishDto}.
     *
     * @param dish сущность "позиция"
     * @return {@link DishDto} dto "позиции"
     */
    @Mapping(target = "menuPositionId", source = "id")
    @Mapping(target = "dishNum", source = "balance")
    DishDto toDto(Dish dish);
}
