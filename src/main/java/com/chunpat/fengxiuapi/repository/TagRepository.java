package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Spu;
import com.chunpat.fengxiuapi.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Integer> {
    List<Tag> getByType(Integer type);
}
