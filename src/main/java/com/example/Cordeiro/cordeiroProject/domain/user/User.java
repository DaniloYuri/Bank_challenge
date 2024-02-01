package com.example.Cordeiro.cordeiroProject.domain.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User implements Serializable {

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
}
