package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
public class GridCategory extends BaseEntity{
    private String title;
    private String img;
    private String name;
    private Integer categoryId;
    private Integer rootCategoryId;
}
