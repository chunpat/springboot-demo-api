package com.chunpat.fengxiuapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderAddress {
    private String city;
    private String county;
    private String detail;
    private String mobile;
    private String nationalCode;
    private String postalCode;
    private String province;
    private String userName;
}
