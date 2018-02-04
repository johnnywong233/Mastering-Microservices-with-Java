package com.packtpub.mmj.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@Slf4j
public class RestaurantApp {

    @Value("${app.rabbitmq.host:localhost}")
    String rabbitMqHost;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApp.class, args);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        log.info("Create RabbitMqCF for host: {}", rabbitMqHost);
        return new CachingConnectionFactory(rabbitMqHost);
    }
}
