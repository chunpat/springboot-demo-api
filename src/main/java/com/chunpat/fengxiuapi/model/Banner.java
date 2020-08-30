package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null")
public class Banner extends BaseEntity{
    private String name;
    private String description;
    private String title;
    private String img;

    @OneToMany(fetch= FetchType.EAGER)
    @JoinColumn(name = "banner_id")
    private List<BannerItem> items;
}
