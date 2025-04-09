package ru.liga.kitchenservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.kitchenservice.feign.WaiterServiceFeignClient;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;
import ru.liga.kitchenservice.service.KitchenOrderService;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class KitchenOrderController {
    private final KitchenOrderService kitchenOrderService;
    private final WaiterServiceFeignClient waiterServiceFeignClient;

    @GetMapping
    public List<KitchenOrderDto> getOrders() {
        return kitchenOrderService.getOrders();
    }

    @PostMapping
    public Long saveOrder(@RequestBody KitchenOrderDto kitchenDto) {
        System.out.println(kitchenDto);
        return kitchenOrderService.saveOrder(kitchenDto);
    }


    @PatchMapping("/{id}/{status}")
    public String updateOrderStatus(@PathVariable Long id, @PathVariable String status) {
        kitchenOrderService.updateOrderStatus(id, status);
        return "Статус обновлен на: " + status;
    }

    @PutMapping("/waiter")
    public String postOrder(@RequestParam Long id) {
        WaiterOrderDto orderDto = kitchenOrderService.getWaiterOrderDto(id);
        Long waiterOrderId = waiterServiceFeignClient.postOrder(orderDto);
        return "Заказ отправлен в ресторан с номером: " + waiterOrderId;

    }
}
