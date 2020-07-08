package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Banner;
import com.chunpat.fengxiuapi.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BannerService {
    @Autowired
    public BannerRepository bannerRepository;

    public Optional<Banner> getByName(String name){
        return this.bannerRepository.findOneByName(name);
    }

    public Optional<Banner> getById(Long id){
        return this.bannerRepository.findOneById(id);
    }
}
