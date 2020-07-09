package com.chunpat.fengxiuapi.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("coupon")
public class CouponController {
    @GetMapping("by/category/{cid}")
    public void getByCategoryId(@PathVariable @NotBlank Integer cid){

    }
}
