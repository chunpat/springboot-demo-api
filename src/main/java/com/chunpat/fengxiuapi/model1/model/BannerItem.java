package com.chunpat.fengxiuapi.model1.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Table(name = "banner_item")
public class BannerItem extends BaseEntity {

    @Column(columnDefinition = "INT(3) COMMENT '年龄'")
//    @JsonIgnore
    private Integer keep;

    private Integer banner_id;

//    @ManyToOne
//    @JoinColumn(name = "banner_id",insertable = false,updatable = false,foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Banner banner;

}
