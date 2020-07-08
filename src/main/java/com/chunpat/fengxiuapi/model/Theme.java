package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Theme extends BaseEntity{
    private String title;
    private String description;
    private String name;
    private String tplName;
    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private Boolean online;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "themeSpu",joinColumns = @JoinColumn(name = "themeId"),inverseJoinColumns = @JoinColumn(name = "spuId"))
    private List<Spu> spuLIst;
}
