package com.adafpc.letscode.banco.repository;

import com.adafpc.letscode.banco.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
