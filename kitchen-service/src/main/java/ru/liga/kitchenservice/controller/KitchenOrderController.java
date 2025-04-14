package ru.liga.kitchenservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.kitchenservice.feign.WaiterServiceFeignClient;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;
import ru.liga.kitchenservice.service.KitchenOrderService;
import java.util.List;

/**
 * Контроллер для взаимодействия с заказами
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class KitchenOrderController {
    private final KitchenOrderService kitchenOrderService;
    private final WaiterServiceFeignClient waiterServiceFeignClient;

    /**
     * Получить заказы
     *
     * @return {@link KitchenOrderDto} Список заказов
     */
    @GetMapping
    public List<KitchenOrderDto> getOrders() {
        return kitchenOrderService.getOrders();
    }

    /**
     * Сохранить заказ
     *
     * @param kitchenDto данные о заказе
     * @return id сохраненного заказа
     */
    @PostMapping
    public Long saveOrder(@RequestBody KitchenOrderDto kitchenDto) {
        return kitchenOrderService.saveOrder(kitchenDto);
    }


    /**
     * Обновление статуса заказа
     *
     * @param id идентификатор заказа
     * @param status статус заказа
     * @return Сообщение об обновлении статуса
     */
    @PatchMapping("/{id}/{status}")
    public String updateOrderStatus(@PathVariable Long id, @PathVariable String status) {
        kitchenOrderService.updateOrderStatus(id, status);
        return "Статус обновлен на: " + status;
    }

    /**
     * Отправить готовый заказ в waiter-service
     *
     * @param id идентификатор заказа со стороны кухни
     * @return Сообщение об отправке заказа на сторону официантов
     */
    @PutMapping("/waiter")
    public String postOrder(@RequestParam Long id) {
        WaiterOrderDto orderDto = kitchenOrderService.getWaiterOrderDto(id);
        Long waiterOrderId = waiterServiceFeignClient.postOrder(orderDto);
        return "Заказ отправлен в ресторан с номером: " + waiterOrderId;
    }
}
