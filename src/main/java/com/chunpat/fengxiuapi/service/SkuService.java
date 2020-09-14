package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.exception.ParameterException;
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

    /**
     * ids 查找
     * @param skuId
     * @param count
     * @return
     */
    public void reduceStock(Long skuId, Integer count){
        if(this.skuRepository.reduceStock(skuId,count) == 0){
            throw new ParameterException(50001);
        }
    }

    /**
     * 增加库存
     * @param skuId
     * @param count
     */
    public void addStock(Long skuId, Integer count){
        if(this.skuRepository.addStock(skuId,count) == 0){
            throw new ParameterException(50001);
        }
    }
}
