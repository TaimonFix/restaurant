package ru.liga.waiterservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.Status;
import ru.liga.waiterservice.service.WaiterOrderService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class WaiterOrderController {
    private final WaiterOrderService orderService;

    @GetMapping
    public List<WaiterOrderDto> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public WaiterOrderDto getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping
    public Long addOrder(@RequestBody WaiterOrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @GetMapping("/status/{id}")
    public Status getStatus(@PathVariable Long id) {
        return orderService.getStatus(id);
    }
}
