package com.chunpat.fengxiuapi.dto;

import com.chunpat.fengxiuapi.core.enumeration.LoginType;
import com.chunpat.fengxiuapi.dto.validator.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenDto {
    private String token;
}
