package uk.co.logiccache;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private final ApplicationProperties properties;

    public KafkaTopicConfig(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(properties.kafkaWikimediaTopicName()).build();
    }
}
