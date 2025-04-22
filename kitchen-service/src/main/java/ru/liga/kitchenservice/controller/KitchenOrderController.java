package ru.liga.kitchenservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.service.KitchenOrderService;
import java.util.List;

/**
 * Контроллер для взаимодействия с заказами.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@Tag(name = "KitchenOrderController",
     description = "Предназначен для работы с заказами на стороне сервиса кухни")
@ApiResponse(responseCode = "200", description = "Запрос выполнен успешно!")
public class KitchenOrderController {

    private final KitchenOrderService kitchenOrderService;

    /**
     * Получить заказы.
     *
     * @return {@link KitchenOrderDto} Список заказов
     */
    @GetMapping
    @Operation(summary = "Получить все заказы")
    @ApiResponse(responseCode = "200", description = "Возвращает все заказы")
    public List<KitchenOrderDto> getOrders() {
        return kitchenOrderService.getOrders();
    }

    /**
     * Обновление статуса заказа на двух сервисах (kitchen-order, waiter-order).
     *
     * @param id     идентификатор заказа
     * @param status статус заказа
     * @return Сообщение об обновлении статуса
     */
    @PutMapping("/{id}/{status}")
    @Operation(summary = "Обновить статус заказа")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Статус заказа обновлен"),
            @ApiResponse(responseCode = "404",
                    description = "Заказ с указанным id не найден! "
                            + "|| Указанный статус отсутствует!")
    })
    public String updateOrderStatus(
            @PathVariable @Parameter(description = "id заказа") final Long id,
            @PathVariable @Parameter(description = "Статус заказа") final String status) {
        kitchenOrderService.updateOrderStatus(id, status);
        return "Статус обновлен на: " + status;
    }
}
