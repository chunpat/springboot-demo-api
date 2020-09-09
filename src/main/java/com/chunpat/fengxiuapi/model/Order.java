package com.chunpat.fengxiuapi.model;

import com.chunpat.fengxiuapi.dto.OrderAddressDto;
import com.chunpat.fengxiuapi.util.GenericAndJson;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="`order`")
public class Order extends BaseEntity{
    private String orderNo;
    private Long userId;
    private BigDecimal totalPrice;
    private Integer totalCount;
    private String snapImg;
    private String snapTitle;
    private String snapItems;
    private String snapAddress;
    private String prepayId;
    private BigDecimal finalTotalPrice;
    private Integer status;
    private Date expireTime;

    public void setSnapItems(List<OrderDetail> orderDetail) {
        if(orderDetail.isEmpty()){
            return;
        }
        this.snapItems =  GenericAndJson.objectToJson(orderDetail);
    }

    public List<OrderDetail> getSnapItems() {
        if(this.snapItems == null){
            return Collections.emptyList();
        }
        return  GenericAndJson.JsonToList(this.snapItems, new TypeReference<List<OrderDetail>>() {});
    }

    public void setSnapAddress(OrderAddressDto orderAddressDto) {
        this.snapAddress =  GenericAndJson.objectToJson(orderAddressDto);
    }

    public List<OrderDetail> getSnapAddress() {
        if(this.snapAddress == null){
            return Collections.emptyList();
        }
        return  GenericAndJson.JsonToList(this.snapAddress, new TypeReference<List<OrderDetail>>() {});
    }


}
