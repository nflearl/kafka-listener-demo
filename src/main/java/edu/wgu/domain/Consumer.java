package edu.wgu.domain;

import edu.wgu.ZZEarl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "private-earl-test")
    public void consume(ConsumerRecord<String, ZZEarl> record) {
        System.out.println("WGUid in record: " + record.value());
        ZZEarl earl = record.value();
        System.out.println("WGUid in record: " + earl.getWguid());
    }
}
