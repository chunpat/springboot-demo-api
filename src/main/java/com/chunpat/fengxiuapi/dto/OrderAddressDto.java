package com.chunpat.fengxiuapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OrderAddressDto {
    @NotBlank()
    private String city;

    @NotBlank()
    private String county;

    @NotBlank()
    private String detail;

    @NotBlank()
    private String mobile;

    @NotBlank()
    private String national_code;

    @NotBlank()
    private String postal_code;

    @NotBlank()
    private String province;

    @NotBlank()
    private String user_name;
}
