package ru.liga.kitchenservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.kitchenservice.model.entity.OrderToDish;

public interface OrderToDishRepository extends JpaRepository<OrderToDish, Long> {
}
