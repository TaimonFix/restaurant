package ru.liga.kitchenservice.kafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.liga.kitchenservice.model.dto.OrderFromWaiterDto;
import ru.liga.kitchenservice.service.KitchenOrderService;

/**
 * Consumer, принимающий сообщения
 * из сервиса официантов при помощи kafka.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer {

    private final KitchenOrderService kitchenOrderService;

    /**
     * Прочитать заказ.
     *
     * @param orderFromWaiterDto данные о заказе
     * со стороны сервиса официантов
     */
    @KafkaListener(topics = "${spring.kafka.producer.created-topic}",
                   concurrency = "${spring.kafka.consumer.concurrency}")
    public void consume(final OrderFromWaiterDto orderFromWaiterDto) {
        try {
            log.info("Поступил заказ {}", orderFromWaiterDto);
            kitchenOrderService.saveOrder(orderFromWaiterDto);
        } catch (Exception e) {
            log.error("Произошла ошибка при сохранении заказа", e);
        }
    }
}
