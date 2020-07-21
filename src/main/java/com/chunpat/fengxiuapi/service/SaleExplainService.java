package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.SaleExplain;
import com.chunpat.fengxiuapi.repository.SaleExplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleExplainService{
    @Autowired
    SaleExplainRepository saleExplainRepository;

    public List<SaleExplain> getByFixed(Boolean fixed){
        return saleExplainRepository.getAllByFixed(fixed);
    }

}
