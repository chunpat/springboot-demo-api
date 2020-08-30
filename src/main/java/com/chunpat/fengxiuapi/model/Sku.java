package com.chunpat.fengxiuapi.model;

import com.chunpat.fengxiuapi.util.GenericAndJson;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity{
    private BigDecimal price;
    private BigDecimal discountPrice;
    private byte online;
    private String img;
    private String title;
    private Long spuId;

    //    @Convert(converter = MapAndJson.class)
//    private Map<String,Object> test;
//    @Convert(converter = ListAndJson.class)
    private String specs;
    private String code;
    private Integer stock;
    private Integer categoryId;
    private Integer rootCategoryId;

    /**
     * 获取最终价格
     * @return
     */
    public BigDecimal getActualPrice() {
        return this.discountPrice != null && this.discountPrice.compareTo(new BigDecimal(0)) != 0 ? this.discountPrice : this.price;
    }

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

    public List<String> getSpecsValue() {
        if(this.specs == null){
            return Collections.emptyList();
        }

        return  this.getSpecs().stream().map(Spec::getValue).collect(Collectors.toList());
    }

}
