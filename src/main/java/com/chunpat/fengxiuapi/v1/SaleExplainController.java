package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.model.SaleExplain;
import com.chunpat.fengxiuapi.service.SaleExplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sale_explain")
public class SaleExplainController {
    @Autowired
    SaleExplainService saleExplainService;

    @GetMapping("fixed")
    public List<SaleExplain> getByfixed(){
        return saleExplainService.getByFixed(Boolean.TRUE);
    }
}
