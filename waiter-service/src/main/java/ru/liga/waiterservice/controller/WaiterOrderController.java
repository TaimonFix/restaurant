package ru.liga.waiterservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.service.WaiterOrderService;
import java.util.List;

/**
 * Контроллер для работы с заказами
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class WaiterOrderController {
    private final WaiterOrderService waiterOrderService;

    /**
     * Получить все заказы
     *
     * @return список заказов
     */
    @GetMapping
    public List<WaiterOrderDto> getOrders() {
        return waiterOrderService.getOrders();
    }

    /**
     * Получить заказ
     *
     * @param id идентификатор заказа
     * @return {@link WaiterOrderDto} заказ
     */
    @GetMapping("/{id}")
    public WaiterOrderDto getOrder(@PathVariable Long id) {
        return waiterOrderService.getOrder(id);
    }

    /**
     * Создать заказ
     *
     * @param orderDto данные о заказе
     * @return id сохраненного заказа
     */
    @PostMapping
    public Long saveOrder(@Valid @RequestBody OrderDto orderDto) {
        return waiterOrderService.saveOrder(orderDto);
    }

    /**
     * Получить статус заказа
     *
     * @param id идентификатор заказа
     * @return {@link OrderStatus} статус заказа
     */
    @GetMapping("/status/{id}")
    public OrderStatus getStatus(@PathVariable Long id) {
        return waiterOrderService.getOrderStatus(id);
    }

    /**
     * Обновить данные о заказе
     *
     * @param orderDto данные о заказе
     * @return идентификатор заказа
     */
    @PutMapping
    public Long updateOrder(@RequestBody WaiterOrderDto orderDto) {
        return waiterOrderService.updateOrder(orderDto);
    }

}
