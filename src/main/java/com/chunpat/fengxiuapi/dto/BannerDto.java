package com.chunpat.fengxiuapi.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@Builder
@Getter
@Valid
public class BannerDto {
    @Max(2)
    private String name;
    @Max(4)
    private String age;
}
