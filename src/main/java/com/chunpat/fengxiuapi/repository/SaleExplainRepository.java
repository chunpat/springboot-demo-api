package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.SaleExplain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleExplainRepository extends JpaRepository<SaleExplain, Boolean> {
    List<SaleExplain> getAllByFixed(Boolean isFixed);
}
