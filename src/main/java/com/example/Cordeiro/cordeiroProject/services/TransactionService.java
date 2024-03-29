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
import java.time.LocalDateTime;
import java.util.Map;

import static jakarta.persistence.criteria.Predicate.BooleanOperator.AND;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

@Autowired
    private NotificationService notificationService;


    @Autowired
    private RestTemplate restTemplate;


    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUser(transaction.senderId());
        User receiver = this.userService.findUser(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.value());

        if(!isAuthorized){
            throw new Exception("Transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReveicer(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());


        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        transactionRepository.save(newTransaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);



        this.notificationService.sendNotification(sender,"Transação Realizada com sucesso");
        this.notificationService.sendNotification(receiver,"Transação Recebida Com sucesso");

        return newTransaction;
    }


    public boolean authorizeTransaction(User sender, BigDecimal value) {
        ResponseEntity<Map> authorizeResponse = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);

        if (authorizeResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authorizeResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        } else return false;
    }
}



