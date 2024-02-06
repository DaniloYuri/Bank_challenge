package com.example.Cordeiro.cordeiroProject.services;


import com.example.Cordeiro.cordeiroProject.domain.transactions.Transaction;
import com.example.Cordeiro.cordeiroProject.domain.user.User;
import com.example.Cordeiro.cordeiroProject.dtos.TransactionDTO;
import com.example.Cordeiro.cordeiroProject.repositories.TransactionRepository;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

import static jakarta.persistence.criteria.Predicate.BooleanOperator.AND;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;


    public void createTransaction(TransactionDTO obj) throws Exception {
        User sender = this.userService.findUserById(obj.senderId());
        User receiver = this.userService.findUserById(obj.receiverId());

        userService.validateTransaction(sender, obj.value());

        boolean isAuthorized = this.authorizeTransaction(sender, obj.value());
        if (!isAuthorized) {
            throw new Exception("Transação não autorizada");

        }

        public boolean authorizeTransaction(User sender, BigDecimal value){
            ResponseEntity<Map> authozirationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", Map.class);


            if (authozirationResponse.getStatusCode() == HttpStatus.OK) {
                String message = (String) authozirationResponse.getBody().get("message");
                return "Autorizado".equalsIgnoreCase(message);
            }

        }

    }
}




