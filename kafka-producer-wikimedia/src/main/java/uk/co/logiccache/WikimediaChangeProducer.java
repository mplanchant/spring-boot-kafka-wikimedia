package uk.co.logiccache;

import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WikimediaChangeProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ApplicationProperties properties;

    public WikimediaChangeProducer(KafkaTemplate<String, String> kafkaTemplate, ApplicationProperties properties) {
        this.kafkaTemplate = kafkaTemplate;
        this.properties = properties;
    }

    public void sendMessage() throws InterruptedException {
        var eventHandler = new WikimediaChangeHandler(kafkaTemplate, properties.kafkaWikimediaTopicName());
        var eventSource = new EventSource.Builder(eventHandler, URI.create(properties.wikiMediaChangeUrl())).build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }
}
