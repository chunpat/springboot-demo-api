package com.chunpat.fengxiuapi.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ActivityPureVo {
    private Long id;
    private String title;
    private Date startTime;
    private Date endTime;
    private String remark;
    private String entranceImg;
}
