package com.example.Cordeiro.cordeiroProject.services;

import com.example.Cordeiro.cordeiroProject.domain.user.User;
import com.example.Cordeiro.cordeiroProject.dtos.NotificatioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NotificationService {



    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification (User user , String message) throws Exception{
        String email = user.getEmail();
        NotificatioDTO notificationRequest = new NotificatioDTO(email, message);

       ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationRequest, String.class);

       if (!(notificationResponse.getStatusCode() == HttpStatus.OK))  {
           System.out.println("erro ao enviar notificaçao");
           throw new Exception("Serviço de notificação fora do ar.");
       }

    }
}
