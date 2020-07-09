package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Setter
@Getter
public class SpuImg extends BaseEntity{
    private String img;
    private Integer spuId;
}
