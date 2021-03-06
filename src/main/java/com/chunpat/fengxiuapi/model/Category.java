package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Category extends BaseEntity{
    private String name;
    private String description;
    private Boolean isRoot;
    private Integer parentId;
    private String img;
    private Integer index;
    private Integer online;
    private Integer level;

}
