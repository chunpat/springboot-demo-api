package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner,Long> {
    Banner findOneByName(String name);
    Banner findOneById(Integer id);
}
