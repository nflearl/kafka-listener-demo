package edu.wgu;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

    @Bean(name = "OurEvents")
    public RecordFilterStrategy<String, Object> recordFilterStrategy() {
        return new RecordFilterStrategy<String, Object>() {
            @Override
            public boolean filter(ConsumerRecord<String, Object> consumerRecord) {
                return !processMe(consumerRecord);
            }

            private static boolean processMe(ConsumerRecord<String, Object> consumerRecord) {
                return consumerRecord.value() instanceof ZZEarl ||
                        consumerRecord.value() instanceof Book;
            }
        };
    }

}