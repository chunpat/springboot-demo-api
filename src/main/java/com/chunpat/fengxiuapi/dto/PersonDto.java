package com.chunpat.fengxiuapi.dto;


import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Valid
public class PersonDto {
    @NotBlank()
    @Max(2)
    private String name;

    @NotBlank()
    @Max(4)
    private String age;

}
