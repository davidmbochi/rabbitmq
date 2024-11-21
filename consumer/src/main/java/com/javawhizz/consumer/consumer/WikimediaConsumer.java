package com.javawhizz.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class WikimediaConsumer {

    @RabbitListener(queues = "wikimedia-queue")
    public void consumeMessages(String message){
        log.info(format("Received message: %s", message));
    }
}
