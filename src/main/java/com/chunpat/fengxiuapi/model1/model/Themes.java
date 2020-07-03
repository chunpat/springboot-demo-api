package com.chunpat.fengxiuapi.model1.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

public class Themes extends BaseEntity {
    private String name;
    @ManyToMany()
    @JoinTable(name = "theme_spu",joinColumns = @JoinColumn(name = "themes_id"),inverseJoinColumns = @JoinColumn(name = "spu_id"))
    private List<Spu> spuList;
}
