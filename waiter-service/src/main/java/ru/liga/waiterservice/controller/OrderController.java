package ru.liga.waiterservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.waiterservice.dto.OrderDto;
import ru.liga.waiterservice.dto.enums.Status;
import ru.liga.waiterservice.service.OrderService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Map<Long, OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping
    public String addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
         return "Заказ " + orderDto + " добавлен.";
    }

    @GetMapping("/status/{id}")
    public Status getStatus(@PathVariable Long id) {
        return orderService.getStatus(id);
    }

}
