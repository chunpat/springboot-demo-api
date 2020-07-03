package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Banner;
import com.chunpat.fengxiuapi.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {
    @Autowired
    public BannerRepository bannerRepository;

    public Banner getByName(String name){
        return this.bannerRepository.findOneByName(name);
    }
}
