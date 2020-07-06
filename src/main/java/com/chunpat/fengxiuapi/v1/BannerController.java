package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.core.annotation.ScopeLevel;
import com.chunpat.fengxiuapi.dto.PersonDto;
import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.model.Banner;
import com.chunpat.fengxiuapi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @Autowired
    BannerService bannerService;

    @PostMapping("/test/{id}")
    @ScopeLevel(value = 8)
    public PersonDto test(
            @PathVariable @Max(2) Integer id,
            @RequestParam String name,
            @RequestBody @NotBlank @Validated PersonDto person) {
//        person.getAge()
//        response.getWriter().write("hello word");
//        throw new NotFoundException(10000, "niubi");
//        PersonDto pto = PersonDto.builder().build();
        return person;
    }

    public Banner getByName( @PathVariable @NotBlank String name){
        Banner banner = this.bannerService.getByName(name);

        if(banner == null){
            throw new NotFoundException(30001);
        }
        return this.bannerService.getByName(name);
    }
}
