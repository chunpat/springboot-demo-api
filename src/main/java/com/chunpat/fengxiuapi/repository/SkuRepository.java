package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface SkuRepository extends JpaRepository<Sku, Long> {
    //spu
    List<Sku> findAllByIdIsIn(ArrayList<Long> idArr);
}
