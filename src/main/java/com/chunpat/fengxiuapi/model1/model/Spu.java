package com.chunpat.fengxiuapi.model1.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

public class Spu extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "spuList")
    private List<Themes> themesList;

}
