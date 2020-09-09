package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface SkuRepository extends JpaRepository<Sku, Long> {
    //spu
    List<Sku> findAllByIdIsIn(ArrayList<Long> idArr);

    //核销库存库存
    @Modifying
    @Query("update Sku s set s.stock = s.stock - :quantity where s.id = :skuId and s.stock >= :quantity")
    int reduceStock(Long skuId, Integer quantity);
}
