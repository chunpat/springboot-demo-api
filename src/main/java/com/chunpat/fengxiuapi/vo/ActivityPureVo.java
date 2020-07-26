package com.chunpat.fengxiuapi.vo;

import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.util.BeanMapperUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class ActivityPureVo {
    private Long id;
    private String title;
    private Date startTime;
    private Boolean oneline;
    private Date endTime;
    private String remark;
    private String entranceImg;

    public ActivityPureVo(Activity activity) {
        BeanUtils.copyProperties(activity,this);
    }
}
