package com.example.Cordeiro.cordeiroProject.services;


import com.example.Cordeiro.cordeiroProject.domain.transactions.Transaction;
import com.example.Cordeiro.cordeiroProject.domain.user.User;
import com.example.Cordeiro.cordeiroProject.dtos.TransactionDTO;
import com.example.Cordeiro.cordeiroProject.repositories.TransactionRepository;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;


@Service
public class TransactionService
{

    @Autowired
    private TransactionRepository transactionRepository ;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;


    public void createTransaction  ( TransactionDTO obj) throws Exception{
        User sender = this.userService.findUserById(obj.senderId());
        User receiver = this.userService.findUserById(obj.receiverId());

        userService.validateTransaction(sender,obj.value());
    }

    public boolean authorizeTransaction(User sender, BigDecimal value){
    ResponseEntity<Map>authoziration = restTemplate.getForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", map.class);


    }

}
