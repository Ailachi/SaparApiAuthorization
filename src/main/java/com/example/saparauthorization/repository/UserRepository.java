package com.example.saparauthorization.repository;

import com.example.saparauthorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
    User getUserByEmailAndPassword(String email, String password);
}
