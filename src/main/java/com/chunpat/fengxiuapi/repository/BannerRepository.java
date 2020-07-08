package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BannerRepository extends JpaRepository<Banner,Long> {
    Optional<Banner> findOneByName(String name);
    Optional<Banner>  findOneById(Long id);
}
