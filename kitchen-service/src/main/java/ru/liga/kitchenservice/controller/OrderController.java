package ru.liga.kitchenservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.kitchenservice.dto.KitchenDto;
import ru.liga.kitchenservice.service.OrderService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Map<Long, KitchenDto> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public String addOrder(@RequestBody KitchenDto kitchenDto) {
        orderService.addOrder(kitchenDto);
        return "Заказ " + kitchenDto + " добавлен.";
    }

    @PatchMapping("/{id}/{status}")
    public String updateOrderStatus(@PathVariable Long id, @PathVariable String status) {
        orderService.updateOrderStatus(id, status);
        return "Статус обновлен на: " + status;

    }


}
