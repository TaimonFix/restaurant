package ru.liga.waiterservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.waiterservice.feign.KitchenServiceFeignClient;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.Status;
import ru.liga.waiterservice.service.WaiterOrderService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class WaiterOrderController {
    private final WaiterOrderService orderService;
    private final KitchenServiceFeignClient kitchenServiceFeignClient;

    /**
     * Получить все заказы
     * @return список заказов
     */
    @GetMapping
    public List<WaiterOrderDto> getOrders() {
        return orderService.getOrders();
    }

    /**
     * Получить заказ
     * @param id идентификатор заказа
     * @return заказ
     */
    @GetMapping("/{id}")
    public WaiterOrderDto getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    /**
     * Создать заказ
     */
    @PostMapping
    public Long addOrder(@RequestBody WaiterOrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    /**
     * Получить статус заказа
     * @param id идентификатор заказа
     */
    @GetMapping("/status/{id}")
    public Status getStatus(@PathVariable Long id) {
        return orderService.getStatus(id);
    }

    /**
     * Отправить заказ на кухню
     * @param id идентификатор заказа со стороны waiter-service
     * @return идентификатор заказа со стороны кухни
     */
    @PostMapping("/kitchen")
    public String postOrder(@RequestParam Long id) {
        Long kitchenOrderId = kitchenServiceFeignClient.postOrder(orderService.toKitchenOrderDto(id));
        return "Заказ отправлен на кухню! Номер заказа: " + kitchenOrderId;
    }
}
