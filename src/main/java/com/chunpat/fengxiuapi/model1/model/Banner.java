package com.chunpat.fengxiuapi.model1.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Table(name = "banner")
public class Banner extends BaseEntity {
    @Column(nullable=false,columnDefinition="VARCHAR(30) COMMENT '第一名'")
    private String firstName;
    @Column(nullable=false,columnDefinition="VARCHAR(30) COMMENT '第二名'")
    private String name;
    @Column(nullable=false,columnDefinition=" INT(11) UNSIGNED COMMENT '年龄'")
    private Integer age;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "banner_id")
    private List<BannerItem> Items;
}
