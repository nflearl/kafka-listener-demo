package edu.wgu.domain;

import edu.wgu.Book;
import edu.wgu.ZZEarl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "private-earl-test", filter = "OurEvents")
    public void consume(ConsumerRecord<String, ZZEarl> record) {
        Object value = record.value();

        if (value instanceof ZZEarl) {
            System.out.println("WGUid in record: " + ((ZZEarl) value).getWguid());
        } else if (value instanceof Book) {
            System.out.println("Book title: " + ((Book) value).getTitle());
        } else {
            System.out.println("Don't know this one: " + value.getClass().getName());
        }
    }
}
