package com.example.Cordeiro.cordeiroProject.services;


import com.example.Cordeiro.cordeiroProject.domain.user.User;
import com.example.Cordeiro.cordeiroProject.domain.user.UserType;
import com.example.Cordeiro.cordeiroProject.dtos.UserDTO;
import com.example.Cordeiro.cordeiroProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


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

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrato"));

    }

    public void saveUser (User obj ) {
        this.userRepository.save(obj);

    }

    public User createUser (UserDTO data) {
        User  newUser = new User (data);
        saveUser(newUser);
        return  newUser;
    }
}
