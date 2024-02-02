package com.example.Cordeiro.cordeiroProject.domain.user;


import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.usertype.UserType;


import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id ;
    private String name;

    private String lastName;
    @Column(unique=true)
    private String email;

    private String password ;
    @Column(unique=true)
    private Integer Document;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;


    public User (){

    }


    public User(Long id, String name, String lastName, String email, String password, Integer document, BigDecimal balance, UserType userType) {
        Id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        Document = document;
        this.balance = balance;
        this.userType = userType;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getDocument() {
        return Document;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDocument(Integer document) {
        Document = document;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
