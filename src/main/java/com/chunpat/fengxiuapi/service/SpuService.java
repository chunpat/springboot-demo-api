package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Spu;
import com.chunpat.fengxiuapi.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class SpuService {
    @Autowired
    public SpuRepository spuRepository;

    public Spu getById(Long id) {
        return this.spuRepository.findOneById(id);
    }

    public Page<Spu> getLatestListPaging(Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size,Sort.by("createTime").descending());
        return this.spuRepository.findAll(page);
    }

    public Page<Spu> getByCategoryId(Long id, Boolean isRoot,Integer pageNum, Integer size) {
        if(isRoot){
            Pageable page = PageRequest.of(pageNum, size,Sort.by("createTime").descending());
            return this.spuRepository.findByRootCategoryId(id,page);
        }
        Pageable page = PageRequest.of(pageNum, size,Sort.by("createTime").descending());
        return this.spuRepository.findByCategoryId(id.intValue(),page);
    }
}
