package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.GridCategory;
import com.chunpat.fengxiuapi.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface GridCategoryRepository extends JpaRepository<GridCategory, String> {
    List<GridCategory> findAll();
}
