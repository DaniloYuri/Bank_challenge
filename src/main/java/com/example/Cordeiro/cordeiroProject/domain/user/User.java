package com.example.Cordeiro.cordeiroProject.domain.user;



import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import com.example.Cordeiro.cordeiroProject.domain.user.UserType;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String name;

    private String lastName;
    @Column(unique = true)
    private String email;

    private String password;
    @Column(unique = true)
    private Integer Document;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

}