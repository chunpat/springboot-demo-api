package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Optional<Activity> findByName(String name);

    Optional<Activity> findFirstById(Long id);
}
