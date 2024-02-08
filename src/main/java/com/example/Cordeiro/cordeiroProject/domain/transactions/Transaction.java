package com.example.Cordeiro.cordeiroProject.domain.transactions;


import com.example.Cordeiro.cordeiroProject.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name="transactions")
@Table (name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    private LocalDateTime timestamp;

}
