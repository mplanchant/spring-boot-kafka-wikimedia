package uk.co.logiccache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaDatabaseConsumer {

    private final WikimediaChangeRepository repository;

    public KafkaDatabaseConsumer(WikimediaChangeRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(
            topics = "${application.kafka-wikimedia-topic-name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage) {
        log.info("Event message received : {}", eventMessage);
        repository.save(
                WikimediaChange.builder().wikiEventData(eventMessage).build()
        );
    }
}
