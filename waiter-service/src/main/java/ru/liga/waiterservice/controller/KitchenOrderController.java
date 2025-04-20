package ru.liga.waiterservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.waiterservice.service.KitchenOrderService;

/**
 * Контроллер для взаимодействия с kitchen-service
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
public class KitchenOrderController {

    private final KitchenOrderService kitchenOrderService;

    /**
     * Отправить заказ на кухню
     *
     * @param id идентификатор заказа со стороны waiter-service
     * @return Сообщение об отправке заказа на кухню с присвоенным идентификатором со стороны кухни
     */
    @PostMapping
    public String postOrder(@RequestParam Long id) {
        kitchenOrderService.postOrderToTheKitchen(id);
        return "Заказ под номером '" + id + "' отправлен на кухню!";
    }
}
