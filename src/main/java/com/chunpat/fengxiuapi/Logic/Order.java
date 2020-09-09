package com.chunpat.fengxiuapi.Logic;

import com.chunpat.fengxiuapi.dto.SkuInfoDto;
import com.chunpat.fengxiuapi.exception.ParameterException;
import com.chunpat.fengxiuapi.model.Sku;
import com.chunpat.fengxiuapi.service.SkuService;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Order {
    /**
     * 通过sku id list 获取sku list
     * @param skuInfoList
     * @param skuService
     * @return
     */
    public static List<Sku> getSkuList(List<SkuInfoDto> skuInfoList,SkuService skuService){
        if(skuInfoList.isEmpty()){
            throw new ParameterException(10000);
        }
        //todo 可以优化，用映射的形式
        ArrayList<Long> idArr = new ArrayList<Long>();
        skuInfoList.forEach(SkuInfoDto->{
            idArr.add(SkuInfoDto.getId());
        });
        List<Sku> skuList = skuService.findAllByIdIsIn(idArr);
        return  skuList;
//        return  BeanMapperUtils.mapList(skuList,Sku.class);
    }

}
