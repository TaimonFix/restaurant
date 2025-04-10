package ru.liga.waiterservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;

/**
 * Feign-client для работы с kitchen-service
 */
@FeignClient(value = "${feign.value}", url = "${feign.url}")
public interface KitchenServiceFeignClient {

    /**
     * Отправить заказ на кухню
     * @param kitchenOrderDto о заказе для отправки на кухню
     * @return id заказа со стороны кухни
     */
    @PostMapping("/order")
    Long postOrder(@RequestBody KitchenOrderDto kitchenOrderDto);
}
