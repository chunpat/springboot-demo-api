package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
public class SaleExplain extends BaseEntity{
    private Boolean fixed;
    private String text;
    private Integer spuId;
    private Integer index;
    private Integer replaceId;
}
