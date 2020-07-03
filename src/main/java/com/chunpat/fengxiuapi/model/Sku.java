package com.chunpat.fengxiuapi.model;

import com.chunpat.fengxiuapi.model1.model.Themes;
import com.chunpat.fengxiuapi.util.GenericAndJson;
import com.chunpat.fengxiuapi.util.ListAndJson;
import com.chunpat.fengxiuapi.util.MapAndJson;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity{
    private BigDecimal price;
    private BigDecimal discount_price;
    private byte online;
    private String img;
    private String title;
    private Integer spu_id;

    //    @Convert(converter = MapAndJson.class)
//    private Map<String,Object> test;
//    @Convert(converter = ListAndJson.class)
    private String specs;
    private String code;
    private Integer stock;
    private Integer category_id;
    private Integer rootCategory_id;

    public void setSpecs(List<Spec> spec) {
        if(spec.isEmpty()){
            return;
        }
        this.specs =  GenericAndJson.objectToJson(spec);
    }

    public List<Spec> getSpecs() {
        if(this.specs == null){
            return Collections.emptyList();
        }
        return  GenericAndJson.JsonToList(this.specs, new TypeReference<List<Spec>>() {});
    }

}
