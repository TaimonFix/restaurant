package ru.liga.kitchenservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.kitchenservice.model.entity.Dish;

/**
 * Репозиторий для работы с блюдами.
 */
@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
