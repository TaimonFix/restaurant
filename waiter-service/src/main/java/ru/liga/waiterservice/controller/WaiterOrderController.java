package ru.liga.waiterservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.waiterservice.feign.KitchenServiceFeignClient;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.service.WaiterOrderService;
import java.util.List;

/**
 * Контроллер для работы с заказами
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class WaiterOrderController {
    private final WaiterOrderService orderService;
    private final KitchenServiceFeignClient kitchenServiceFeignClient;

    /**
     * Получить все заказы
     *
     * @return список заказов
     */
    @GetMapping
    public List<WaiterOrderDto> getOrders() {
        return orderService.getOrders();
    }

    /**
     * Получить заказ
     *
     * @param id идентификатор заказа
     * @return {@link WaiterOrderDto} заказ
     */
    @GetMapping("/{id}")
    public WaiterOrderDto getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    /**
     * Создать заказ
     *
     * @param orderDto данные о заказе
     * @return id сохраненного заказа
     */
    @PostMapping
    public Long saveOrder(@RequestBody WaiterOrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    /**
     * Получить статус заказа
     *
     * @param id идентификатор заказа
     * @return {@link OrderStatus} статус заказа
     */
    @GetMapping("/status/{id}")
    public OrderStatus getStatus(@PathVariable Long id) {
        return orderService.getOrderStatus(id);
    }

    /**
     * Обновить данные о заказе
     *
     * @param orderDto данные о заказе
     * @return идентификатор заказа
     */
    @PutMapping("/kitchen")
    public Long updateOrder(@RequestBody WaiterOrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }

    /**
     * Отправить заказ на кухню
     *
     * @param id идентификатор заказа со стороны waiter-service
     * @return Сообщение об отправке заказа на кухню с присвоенным идентификатором со стороны кухни
     */
    @PostMapping("/kitchen")
    public String postOrder(@RequestParam Long id) {
        Long kitchenOrderId = kitchenServiceFeignClient.postOrder(orderService.toKitchenOrderDto(id));
        return "Заказ отправлен на кухню! Номер заказа на кухне: " + kitchenOrderId;
    }
}
