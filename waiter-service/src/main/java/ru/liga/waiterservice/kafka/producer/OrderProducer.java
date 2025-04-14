package ru.liga.waiterservice.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;

@Component
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<Long, Object> kafkaTemplate;

    @Value("${spring.kafka.producer.created-topic}")
    private String topic;

    /**
     * Отправить данные о заказе на кухню
     *
     * @param kitchenOrderDto заказ
     */
    public void produce(KitchenOrderDto kitchenOrderDto) {
        kafkaTemplate.send(topic, kitchenOrderDto);
    }
}
