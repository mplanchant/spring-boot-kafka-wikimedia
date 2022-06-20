package uk.co.logiccache;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
public record ApplicationProperties(String kafkaWikimediaTopicName) {
}