package ru.liga.waiterservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Конфигурация kafka.
 */
@Configuration
public class KafkaConfig {

    /**
     * Название топика.
     */
    @Value("${spring.kafka.producer.created-topic}")
    private String topic;

    /**
     * Создание топика.
     *
     * @return {@link NewTopic} топик с 1-й партицией
     */
    @Bean
    public NewTopic createdTopic() {
        return TopicBuilder.name(topic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
