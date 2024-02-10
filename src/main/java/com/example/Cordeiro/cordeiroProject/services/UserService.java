package com.example.Cordeiro.cordeiroProject.services;


import com.example.Cordeiro.cordeiroProject.domain.user.User;
import com.example.Cordeiro.cordeiroProject.domain.user.UserType;
import com.example.Cordeiro.cordeiroProject.dtos.UserDTO;
import com.example.Cordeiro.cordeiroProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public void validateTransaction (User sender, BigDecimal amount) throws Exception{
          if (sender.getUserType().equals(UserType.MERCHANT) ){
              throw  new Exception("Transação não autoriazada para usuarios do tipo Lojista");
          }


          if(sender.getBalance().compareTo(amount)<0){
              throw new Exception("Saldo Insuficiente.");
          }

    }

    public User findUser(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrato"));

    }

    public void saveUser (User user ) {
        this.userRepository.save(user);

    }

    public User createUser (UserDTO data) {
        User  newUser = new User (data);
        saveUser(newUser);
        return  newUser;
    }

    public List <User> getAllUsers (){
        return this.userRepository.findAll();
    }
}
