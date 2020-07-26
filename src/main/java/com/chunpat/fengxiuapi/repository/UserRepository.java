package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByOpenid(String openid);

    Optional<User> findById(Long id);

    Optional<User> findFirstById(Long id);
}
