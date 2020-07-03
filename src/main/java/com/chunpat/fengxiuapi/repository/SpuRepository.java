package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Banner;
import com.chunpat.fengxiuapi.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<Spu,Long> {
    Spu findOneById(Long id);

    Page<Spu> findByRootCategoryId(Long id, Pageable page);

    Page<Spu> findByCategoryId(Integer cid, Pageable page);
}
