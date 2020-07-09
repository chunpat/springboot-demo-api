package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
