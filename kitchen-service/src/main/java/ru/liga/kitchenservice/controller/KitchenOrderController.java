package ru.liga.kitchenservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.service.KitchenOrderService;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class KitchenOrderController {
    private final KitchenOrderService kitchenOrderService;

    @GetMapping
    public List<KitchenOrderDto> getOrders() {
        return kitchenOrderService.getOrders();
    }

    @PostMapping
    public Long saveOrder(@RequestBody KitchenOrderDto kitchenDto) {
        return kitchenOrderService.saveOrder(kitchenDto);
    }

    @PatchMapping("/{id}/{status}")
    public String updateOrderStatus(@PathVariable Long id, @PathVariable String status) {
        kitchenOrderService.updateOrderStatus(id, status);
        return "Статус обновлен на: " + status;
    }
}
