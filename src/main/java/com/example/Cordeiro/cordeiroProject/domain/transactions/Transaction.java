package com.example.Cordeiro.cordeiroProject.domain.transactions;


import com.example.Cordeiro.cordeiroProject.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name="transactions")
@Table (name="transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender ;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User reveicer;
    private BigDecimal amount ;
}