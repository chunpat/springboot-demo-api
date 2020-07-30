package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Category;
import com.chunpat.fengxiuapi.model.Coupon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CouponCategoryPureVo extends CouponPureVo{
    private List<CategoryPureVo> categoryList = new ArrayList<>();

    public CouponCategoryPureVo(Coupon coupon) {
        super(coupon);
        List<Category> categories = coupon.getCategoryList();
        categories.forEach(c -> {
            CategoryPureVo vo = new CategoryPureVo(c);
            this.categoryList.add(vo);
        });
    }
}
