package com.example.Cordeiro.cordeiroProject.repositories;

import com.example.Cordeiro.cordeiroProject.domain.user.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long > {
}
