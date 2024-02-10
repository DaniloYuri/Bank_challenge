package com.example.Cordeiro.cordeiroProject.dtos;

import com.example.Cordeiro.cordeiroProject.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, BigDecimal balance, String email, String password, String document, UserType userType) {
}
