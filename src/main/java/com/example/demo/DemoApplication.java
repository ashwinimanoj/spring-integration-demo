package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private BookFactory bookFactory;

    public static void main(String[] args) {
        SpringApplication sp = new SpringApplication(DemoApplication.class);
        sp.setWebApplicationType(WebApplicationType.NONE);
        sp.run();
    }

    private void run(ConfigurableApplicationContext context) {
        System.out.println("-------- Inside Producer run --------");
        MessageChannel producerChannel = context.getBean("producerChannel", MessageChannel.class);
        List<Book> books = bookFactory.getBooks();
        for (Book book : books) {
            Map<String, String> headers = Collections.singletonMap(KafkaHeaders.TOPIC, book.getGenre().toString());
            GenericMessage message = new GenericMessage(book.toString(), headers);
            producerChannel.send(message);
        }
        System.out.println("----Finished Producer run ---------");
    }

}
