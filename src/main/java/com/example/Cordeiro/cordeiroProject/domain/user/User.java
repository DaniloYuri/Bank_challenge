package com.example.Cordeiro.cordeiroProject.domain.user;



import com.example.Cordeiro.cordeiroProject.dtos.UserDTO;
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
@NoArgsConstructor
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;
    @Column(unique = true)
    private String email;

    private String password;
    @Column(unique = true)
    private String document;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public  User (UserDTO user ) {
        this.firstName = user.firstName();
        this.lastName = user.lastName();
        this.email = user.email();
        this.password = user.password();
        this.balance = user.balance();
        this.userType =user.userType();
        this.document = user.document();
    }

}