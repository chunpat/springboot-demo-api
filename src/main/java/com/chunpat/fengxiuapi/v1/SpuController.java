package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.bo.PageCounter;
import com.chunpat.fengxiuapi.dto.PersonDto;
import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.model.Banner;
import com.chunpat.fengxiuapi.model.Spu;
import com.chunpat.fengxiuapi.service.BannerService;
import com.chunpat.fengxiuapi.service.SpuService;
import com.chunpat.fengxiuapi.util.Common;
import com.chunpat.fengxiuapi.vo.PagingDozer;
import com.chunpat.fengxiuapi.vo.SpuSimplifyVo;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {
    @Autowired
    SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(
            @PathVariable @Positive Long id
    ) {
        Spu spu = this.spuService.getById(id);
        if (spu == null) {
            throw new NotFoundException();
        }
        return spu;
    }

    @GetMapping("/id/{id}/getSpuSimplify")
    public SpuSimplifyVo getSpuSimplify(
            @PathVariable @Positive Long id
    ) {
        Spu spu = this.spuService.getById(id);
        if (spu == null) {
            throw new NotFoundException();
        }
        SpuSimplifyVo SpuSimplifyVo = new SpuSimplifyVo();
        BeanUtils.copyProperties(spu, SpuSimplifyVo);
        return SpuSimplifyVo;
    }

    @GetMapping("/latest")
    public PagingDozer<Spu, SpuSimplifyVo> getLatestList(
            @RequestParam(defaultValue = "1") Integer start,
            @RequestParam(defaultValue = "10") Integer count
    ) {
        PageCounter pageCounter = Common.convertToPageParameter(start, count);
        Page<Spu> page = this.spuService.getLatestListPaging(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVo.class);
    }

    @GetMapping("by/category/{id}")
    public PagingDozer<Spu, SpuSimplifyVo> getByCategoryId(
            @PathVariable @Positive Long id,
            @RequestParam(defaultValue = "false") boolean is_root,
            @RequestParam(defaultValue = "1") Integer start,
            @RequestParam(defaultValue = "10") Integer count
    ) {
        PageCounter pageCounter = Common.convertToPageParameter(start, count);
        Page<Spu> page = this.spuService.getByCategoryId(id, is_root, pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVo.class);
    }
}
