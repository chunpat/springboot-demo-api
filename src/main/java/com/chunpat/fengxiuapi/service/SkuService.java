package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Sku;
import com.chunpat.fengxiuapi.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkuService {
    @Autowired
    SkuRepository skuRepository;

    /**
     * ids 查找
     * @param idArr
     * @return
     */
    public List<Sku> findAllByIdIsIn(ArrayList<Long> idArr){
        return this.skuRepository.findAllByIdIsIn(idArr);
    }
}
