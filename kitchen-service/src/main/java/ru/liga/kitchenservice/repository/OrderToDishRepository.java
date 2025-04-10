package ru.liga.kitchenservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.kitchenservice.model.entity.OrderToDish;

/**
 * Репозиторий для реализации связи 'Многие-ко-многим' между таблицами 'kitchen-order', 'dish'
 */
public interface OrderToDishRepository extends JpaRepository<OrderToDish, Long> {
}
