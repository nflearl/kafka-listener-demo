package edu.wgu.domain;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class Consumer {

    @KafkaListener(topics = "private-earl-test")
    public void listen(String value, String topic, String key) {
        System.out.println(value);
    }
}
