package uk.co.logiccache;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class SpringBootApplicationProducer implements CommandLineRunner {

    private final WikimediaChangeProducer wikimediaChangeProducer;

    public SpringBootApplicationProducer(WikimediaChangeProducer wikimediaChangeProducer) {
        this.wikimediaChangeProducer = wikimediaChangeProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationProducer.class);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangeProducer.sendMessage();
    }
}