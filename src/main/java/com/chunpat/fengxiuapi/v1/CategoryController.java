package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.exception.NotFoundException;
import com.chunpat.fengxiuapi.model.Activity;
import com.chunpat.fengxiuapi.model.Category;
import com.chunpat.fengxiuapi.model.GridCategory;
import com.chunpat.fengxiuapi.repository.GridCategoryRepository;
import com.chunpat.fengxiuapi.service.ActivityService;
import com.chunpat.fengxiuapi.service.CategoryService;
import com.chunpat.fengxiuapi.util.BeanMapperUtils;
import com.chunpat.fengxiuapi.vo.ActivityPureVo;
import com.chunpat.fengxiuapi.vo.CategoryAllPureVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ActivityService activityService;
    @Autowired
    GridCategoryRepository gridCategoryRepository;

    @Autowired
    CategoryService categoryService;

    @GetMapping("all")
    public CategoryAllPureVo getAll(){
        return BeanMapperUtils.map(this.categoryService.getAll(),CategoryAllPureVo.class);
    }

    @GetMapping("grid/all")
    public List<GridCategory> getGridCategoryAll(){
        return this.gridCategoryRepository.findAll();
    }
}
