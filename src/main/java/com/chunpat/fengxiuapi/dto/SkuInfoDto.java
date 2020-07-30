package com.chunpat.fengxiuapi.dto;

import com.chunpat.fengxiuapi.core.enumeration.LoginType;
import com.chunpat.fengxiuapi.dto.validator.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class SkuInfoDto {
    private Long id;
    private Integer count;
}
