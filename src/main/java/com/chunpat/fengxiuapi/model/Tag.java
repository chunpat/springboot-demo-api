package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Tag extends BaseEntity{
    private String title;
    private String description;
    private Integer highlight;
    private Integer type;
}
