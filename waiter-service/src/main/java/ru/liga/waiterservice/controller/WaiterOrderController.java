package ru.liga.waiterservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import ru.liga.waiterservice.model.dto.OrderDto;
import ru.liga.waiterservice.model.dto.WaiterOrderDto;
import ru.liga.waiterservice.model.dto.enums.OrderStatus;
import ru.liga.waiterservice.service.WaiterOrderService;
import java.util.List;

/**
 * Контроллер для работы с заказами.
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@Tag(name = "WaiterOrderController",
     description = "Предназначен для работы с заказами на стороне сервиса официантов")
public class WaiterOrderController {

    private final WaiterOrderService waiterOrderService;

    /**
     * Получить все заказы.
     *
     * @return список заказов
     */
    @GetMapping
    @Operation(summary = "Получить все заказы")
    @ApiResponse(responseCode = "200", description = "Возвращает все заказы")
    public List<WaiterOrderDto> getOrders() {
        return waiterOrderService.getOrders();
    }

    /**
     * Получить заказ.
     *
     * @param id идентификатор заказа
     * @return {@link WaiterOrderDto} заказ
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получить заказ по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Возвращает заказ"),
            @ApiResponse(responseCode = "404", description = "Заказ с указанным id не найден!")
            })
    public WaiterOrderDto getOrder(@PathVariable @Parameter(description = "id заказа") final Long id) {
        return waiterOrderService.getOrder(id);
    }

    /**
     * Создать заказ.
     *
     * @param orderDto данные о заказе
     * @return id сохраненного заказа
     */
    @PostMapping
    @Operation(summary = "Создать заказ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Возвращает id созданного заказа"),
            @ApiResponse(responseCode = "404", description = "Отсутствует одно из необходимых полей!")
            })
    public Long saveOrder(@Valid @RequestBody final OrderDto orderDto) {
        return waiterOrderService.saveOrder(orderDto);
    }

    /**
     * Получить статус заказа.
     *
     * @param id идентификатор заказа
     * @return {@link OrderStatus} статус заказа
     */
    @GetMapping("/status/{id}")
    @Operation(summary = "Получить статус заказа")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Возвращает статус заказа"),
            @ApiResponse(responseCode = "404", description = "Заказ с указанным id не найден!")
            })
    public OrderStatus getStatus(@PathVariable @Parameter(description = "id заказа") final Long id) {
        return waiterOrderService.getOrderStatus(id);
    }

    /**
     * Обновить данные о заказе.
     *
     * @param waiterOrderDto данные о заказе
     * @return идентификатор заказа
     */
    @PutMapping
    @Operation(summary = "Обновить данные о заказе")
    @ApiResponse(responseCode = "200", description = "Возвращает id обновленного заказа")
    public Long updateOrder(@RequestBody final WaiterOrderDto waiterOrderDto) {
        return waiterOrderService.updateOrder(waiterOrderDto);
    }
}
