package ru.liga.waiterservice.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.liga.waiterservice.model.dto.KitchenOrderDto;


/**
 * Producer, который занимается отправкой заказа на кухню через Kafka.
 */
@Component
@RequiredArgsConstructor
public class OrderProducer {

    /**
     * {@link KafkaTemplate} предназначен для отправки сообщений в kafka.
     */
    private final KafkaTemplate<Long, Object> kafkaTemplate;

    /**
     * Название топика.
     */
    @Value("${spring.kafka.producer.created-topic}")
    private String topic;

    /**
     * Отправить данные о заказе на кухню.
     *
     * @param kitchenOrderDto заказ
     */
    public void produce(final KitchenOrderDto kitchenOrderDto) {
        kafkaTemplate.send(topic, kitchenOrderDto);
    }
}
