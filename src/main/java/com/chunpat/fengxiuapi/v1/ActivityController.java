package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.service.ActivityService;
import com.chunpat.fengxiuapi.vo.ActivityCouponPureVo;
import com.chunpat.fengxiuapi.vo.ActivityPureVo;
import com.chunpat.fengxiuapi.vo.SpuSimplifyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping("name/{name}/with_coupon")
    public ActivityCouponPureVo getWithCouponByName(@PathVariable @NotBlank String name){
        Optional<Activity> activity = this.activityService.findByName(name);
        activity.orElseThrow(()->new NotFoundException(10002));
        return new ActivityCouponPureVo(activity.get());
    }

    @GetMapping("name/{name}")
    public ActivityPureVo getByName(@PathVariable @NotBlank String name){
        Optional<Activity> activity = this.activityService.findByName(name);
        activity.orElseThrow(()->new NotFoundException(10002));
        return new ActivityPureVo(activity.get());
    }
}
