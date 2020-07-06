package com.chunpat.fengxiuapi.dto;

import com.chunpat.fengxiuapi.core.enumeration.LoginType;
import com.chunpat.fengxiuapi.dto.validator.TokenPassword;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenGetDto {
    @NotBlank(message = "{token.account}")
    private String account;

    @TokenPassword(max = 30,message = "{token.password}")
    private String password;

    private LoginType loginType;

}
