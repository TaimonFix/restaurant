package ru.liga.kitchenservice.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.liga.kitchenservice.model.dto.KitchenOrderDto;
import ru.liga.kitchenservice.service.KitchenOrderService;

@Component
@RequiredArgsConstructor
public class OrderConsumer {

    private final KitchenOrderService kitchenOrderService;

    @KafkaListener(topics = "${spring.kafka.producer.created-topic}",
                   concurrency = "${spring.kafka.consumer.concurrency}")
    public void consume(KitchenOrderDto kitchenOrderDto) {
        kitchenOrderService.saveOrder(kitchenOrderDto);
        System.out.println("saved order: " + kitchenOrderDto);
    }
}
