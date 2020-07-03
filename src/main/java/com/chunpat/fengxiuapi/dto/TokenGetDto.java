package com.chunpat.fengxiuapi.dto;

import com.chunpat.fengxiuapi.core.enumeration.LoginType;
import com.chunpat.fengxiuapi.dto.validator.TokenPassword;

import javax.validation.constraints.NotBlank;

public class TokenGetDto {
    @NotBlank(message = "account不允许为空")
    private String account;

    @TokenPassword(min = 6,max = 30)
    private String password;

    private LoginType type;

}
