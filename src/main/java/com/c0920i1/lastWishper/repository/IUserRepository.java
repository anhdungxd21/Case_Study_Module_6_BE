package com.c0920i1.lastWishper.repository;

import com.c0920i1.lastWishper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
