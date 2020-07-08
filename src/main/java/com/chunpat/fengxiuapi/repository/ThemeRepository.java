package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ThemeRepository extends JpaRepository<Theme, String> {
    List<Theme> findAllByNameIsIn( ArrayList<String> set);
    List<Theme> findAll();
    Optional<Theme> findThemeByName(String name);
}
