package ru.liga.kitchenservice.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.service.KitchenOrderService;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer {

    private final KitchenOrderService kitchenOrderService;

    @KafkaListener(topics = "${spring.kafka.producer.created-topic}",
                   concurrency = "${spring.kafka.consumer.concurrency}")
    public void consume(OrderFromWaiterDto orderFromWaiterDto) {
        log.info("Поступил заказ {}", orderFromWaiterDto);
        kitchenOrderService.saveOrder(orderFromWaiterDto);
    }
}
