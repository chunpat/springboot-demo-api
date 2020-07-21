package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Tag;
import com.chunpat.fengxiuapi.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getByType(Integer type){
        return tagRepository.getByType(type);
    }
}
