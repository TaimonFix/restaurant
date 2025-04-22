package ru.liga.kitchenservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;

/**
 * Feign-client для работы с waiter-service.
 */
@FeignClient(value = "${feign.value}", url = "${feign.url}")
public interface WaiterServiceFeignClient {

    /**
     * Отправить заказ на кухню.
     *
     * @param waiterOrderDto данные о заказе
     * @return id заказа со стороны сервиса официантов
     */
    @PutMapping("/order")
    Long postOrder(@RequestBody WaiterOrderDto waiterOrderDto);
}
