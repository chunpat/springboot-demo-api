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
import java.util.Optional;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    @Autowired
    BannerService bannerService;

    /**
     * 获取banner 通过名字
     * @param name
     * @return
     */
    @GetMapping("name/{name}")
    public Optional<Banner> getByName( @PathVariable @NotBlank String name){
        Optional<Banner> banner = this.bannerService.getByName(name);
        banner.orElseThrow(()-> new NotFoundException(30003));
        return banner;
    }

    /**
     * 获取banner 通过id
     * @param id
     * @return
     */
    @GetMapping("id/{id}")
    public Optional<Banner> getById( @PathVariable Long id){
        Optional<Banner> banner = this.bannerService.getById(id);
        banner.orElseThrow(()-> new NotFoundException(30003));
        return banner;
    }
}
