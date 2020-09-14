package com.chunpat.fengxiuapi.util;

import com.chunpat.fengxiuapi.bo.PageCounter;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Common {

    //分页参数转换成PageCounter
    public static PageCounter convertToPageParameter(Integer start, Integer count){
        Integer page = start / count;
        PageCounter pageCounter = PageCounter.builder().page(page).count(count).build();
        return pageCounter;
    }

    //vo list copy
    public static <K, T> List<K> list2VoList(List<T> list, Class<K> KClass){
        if(list.isEmpty()){
            return null;
        }
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> vo = new ArrayList<>();
        list.forEach(v -> {
            K k = mapper.map(v, KClass);
            vo.add(k);
        });
        return vo;
    }

    //是否在时间内
    public static Boolean isInTimeLine(Date now, Date startDate,Date endData){
        if(!now.after(startDate) || !now.before(endData)){
            return false;
        }
        return true;
    }

    /**
     * 计算过期时间
     * @param now 当前calendar
     * @param expireTime 过期时间秒数
     * @return Calendar
     */
    public static Calendar expireTime(Calendar now, int expireTime){
        now.add(Calendar.SECOND,expireTime);
        return now;
    }

    /**
     * 获取10位时间戳
     * @return
     */
    public static String timestamp10(){
        Long timestamp13 = Calendar.getInstance().getTimeInMillis();
        String timestamp13String = timestamp13.toString();
        return timestamp13String.substring(0,timestamp13String.length()-3);
    }
}
