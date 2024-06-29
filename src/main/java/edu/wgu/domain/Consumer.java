package edu.wgu.domain;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import edu.wgu.ZZEarl;

@Component
public class Consumer {

    @KafkaListener(topics = "private-earl-test")
    public void consume(ConsumerRecord<String, ZZEarl> record) {
        System.out.println("WGUid in record: " + record.value());
    }
}
