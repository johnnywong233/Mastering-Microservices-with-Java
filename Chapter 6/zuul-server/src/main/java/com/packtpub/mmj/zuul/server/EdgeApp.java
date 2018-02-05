package com.packtpub.mmj.zuul.server;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableCircuitBreaker
@EnableResourceServer
@Configuration
@EnableFeignClients
public class EdgeApp {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private static final Logger LOG = LoggerFactory.getLogger(EdgeApp.class);

    @Value("${app.rabbitmq.host:localhost}")
    String rabbitMqHost;

    @Bean
    public ConnectionFactory connectionFactory() {
        LOG.info("Create RabbitMqCF for host: {}", rabbitMqHost);
        return new CachingConnectionFactory(rabbitMqHost);
    }

    public static void main(String[] args) {
        SpringApplication.run(EdgeApp.class, args);
    }
}

@Component
class DiscoveryClientSample implements CommandLineRunner {

    @Resource
    private DiscoveryClient discoveryClient;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(discoveryClient.description());
        discoveryClient.getInstances("restaurant-service").forEach((ServiceInstance serviceInstance) -> {
            System.out.println("Instance --> " + serviceInstance.getServiceId()
                    + "\nServer: " + serviceInstance.getHost() + ":" + serviceInstance.getPort()
                    + "\nURI: " + serviceInstance.getUri() + "\n\n\n");
        });
    }
}

@Component
class RestTemplateExample implements CommandLineRunner {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("\n\n\n start RestTemplate client...");
        ResponseEntity<Collection<Restaurant>> exchange
                = this.restTemplate.exchange(
                "http://restaurant-service/v1/restaurants?name=o",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Collection<Restaurant>>() {
                },
                (Object) "restaurants");
        exchange.getBody().forEach((Restaurant restaurant) -> {
            System.out.println("\n\n\n[ " + restaurant.getId() + " " + restaurant.getName() + "]");
        });
    }
}

@FeignClient("restaurant-service")
interface RestaurantClient {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/restaurants")
    Collection<Restaurant> getRestaurants(@RequestParam("name") String name);
}

@Component
class FeignSample implements CommandLineRunner {

    @Resource
    private RestaurantClient restaurantClient;

    @Override
    public void run(String... strings) throws Exception {
        this.restaurantClient.getRestaurants("o").forEach((Restaurant restaurant) -> {
            System.out.println("\n\n\n[ " + restaurant.getId() + " " + restaurant.getName() + "]");
        });
    }
}

@Data
@NoArgsConstructor
class Restaurant {

    private List<Table> tables = new ArrayList<>();
    private String id;
    private boolean isModified;
    private String name;

    public Restaurant(String name, String id, List<Table> tables) {
        this.tables = tables;
    }
}

@Data
class Table {
    private int capacity;

    public Table(String name, BigInteger id, int capacity) {
        this.capacity = capacity;
    }
}