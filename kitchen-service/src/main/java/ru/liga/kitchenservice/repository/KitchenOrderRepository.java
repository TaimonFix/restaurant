package ru.liga.kitchenservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.kitchenservice.model.entity.KitchenOrder;

/**
 * Репозиторий для работы с заказами
 */
@Repository
public interface KitchenOrderRepository extends JpaRepository<KitchenOrder, Long> {
}
