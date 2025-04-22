package ru.liga.waiterservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liga.waiterservice.service.KitchenOrderService;

/**
 * Контроллер для взаимодействия с kitchen-service по API.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
@Tag(name = "KitchenOrderController",
        description = "Предназначен для отправки сформированных заказов на кухню")

public class KitchenOrderController {

    private final KitchenOrderService kitchenOrderService;

    /**
     * Отправить заказ на кухню.
     *
     * @param id идентификатор заказа со стороны waiter-service
     * @return Сообщение об отправке заказа на кухню с присвоенным идентификатором со стороны кухни
     */
    @PostMapping
    @Operation(summary = "Отправить заказ на кухню")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Сообщение об успешной отправке заказа на кухню"),
            @ApiResponse(responseCode = "409", description = "Заказ уже отправлен на кухню!"),
            @ApiResponse(responseCode = "404", description = "Заказ с указанным id не найден!")
            })
    public String postOrder(@RequestParam @Parameter(description = "id заказа") final Long id) {
        kitchenOrderService.postOrderToTheKitchen(id);
        return "Заказ под номером '" + id + "' отправлен на кухню!";
    }
}
