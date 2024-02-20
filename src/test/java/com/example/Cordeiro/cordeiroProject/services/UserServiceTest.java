package com.example.Cordeiro.cordeiroProject.services;

import com.example.Cordeiro.cordeiroProject.domain.user.User;
import com.example.Cordeiro.cordeiroProject.domain.user.UserType;
import com.example.Cordeiro.cordeiroProject.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class UserServiceTest {

    private MockMvc mockMvc;
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    User newUser ;

    @BeforeEach
    public void setUp(){
         newUser = new User (null,"Roberto","Cordeiro","roberto@gmail.com","123","47686816111",null ,UserType.COMMON);
    }

    @Test
    void validateTransaction() {
    }

    @Test
    void mustFindUserSuccessfully() throws Exception {
        when(userRepository.findById(newUser.getId())).thenReturn(Optional.ofNullable(newUser));
        userService.findUser(newUser.getId());
    }

    @Test
    void saveUser() {
    }

    @Test
    void createUser() {
    }

    @Test
    void getAllUsers() {
    }
}