package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "banner_item", schema = "fengxiu", catalog = "")
public class BannerItem extends BaseEntity{
    private String img;
    private String keyword;
    private short type;
    private int banner_id;
    private String name;

}
