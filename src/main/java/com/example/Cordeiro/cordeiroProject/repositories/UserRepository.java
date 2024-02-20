package com.example.Cordeiro.cordeiroProject.repositories;

import com.example.Cordeiro.cordeiroProject.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
