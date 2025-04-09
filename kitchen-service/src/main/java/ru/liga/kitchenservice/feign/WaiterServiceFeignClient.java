package ru.liga.kitchenservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.liga.kitchenservice.model.dto.WaiterOrderDto;

/**
 * Feign-client для работы с waiter-service
 */
@FeignClient(value = "${feign.value}", url = "${feign.url}")
public interface WaiterServiceFeignClient {

    /**
     * Отправить заказ на кухню
     */
    @PutMapping("/order/kitchen")
    Long postOrder(@RequestBody WaiterOrderDto waiterOrderDto);
}
