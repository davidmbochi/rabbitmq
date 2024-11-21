package com.javawhizz.producer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {
    private final AmqpAdmin rabbitAdmin;

    @Bean
    public Queue queue(){
        return new Queue("wikimedia-queue", false);
    }

    @Bean
    public Exchange exchange(){
        return new DirectExchange("wikimedia-exchange");
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange){
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("wikimedia-key")
                .noargs();
    }

}
