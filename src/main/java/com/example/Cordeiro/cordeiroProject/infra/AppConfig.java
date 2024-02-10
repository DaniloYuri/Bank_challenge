package com.example.Cordeiro.cordeiroProject.infra;


import com.example.Cordeiro.cordeiroProject.services.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public NotificationService notificationService(){
        return new NotificationService();
    }
}
