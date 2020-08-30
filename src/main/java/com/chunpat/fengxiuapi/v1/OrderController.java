package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.Logic.Order;
import com.chunpat.fengxiuapi.Logic.PlaceOrderChecker;
import com.chunpat.fengxiuapi.core.LocalUser;
import com.chunpat.fengxiuapi.core.UnifyResponse;
import com.chunpat.fengxiuapi.core.annotation.ScopeLevel;
import com.chunpat.fengxiuapi.dto.OrderDto;
import com.chunpat.fengxiuapi.model.Sku;
import com.chunpat.fengxiuapi.model.User;
import com.chunpat.fengxiuapi.service.OrderService;
import com.chunpat.fengxiuapi.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    SkuService skuService;

    @Value("${missyou.sku.skuMaxLimit}")
    private Integer skuMaxLimit;

    /**
     * 下单
     * 1、将sku list id转换为sku list
     * 2、校验下单sku 和 count是否正确，校验总价格
     * 3、如果有优惠券，检验优惠券，和最终价格
     * 4、整理数据下单
     *
     * @param orderDto
     */
    @PostMapping("")
    @ScopeLevel
    public void placeOrder(@RequestBody @NotBlank OrderDto orderDto) {
        User user = LocalUser.getUser();
        List<Sku> serviceSkuList = Order.getSkuList(orderDto.getSkuInfoList(), this.skuService);

        //订单检测
        PlaceOrderChecker placeOrderChecker = new PlaceOrderChecker(serviceSkuList, orderDto, this.skuMaxLimit);
        this.orderService.isOk(user.getId(), placeOrderChecker);

        //下订单
        this.orderService.placeOrder(user.getId(), orderDto, placeOrderChecker);

        UnifyResponse.createSuccess();
    }
}
