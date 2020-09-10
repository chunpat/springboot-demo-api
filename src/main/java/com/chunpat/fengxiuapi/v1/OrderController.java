package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.Logic.PlaceOrderChecker;
import com.chunpat.fengxiuapi.bo.PageCounter;
import com.chunpat.fengxiuapi.core.LocalUser;
import com.chunpat.fengxiuapi.core.annotation.ScopeLevel;
import com.chunpat.fengxiuapi.dto.OrderDto;
import com.chunpat.fengxiuapi.model.Order;
import com.chunpat.fengxiuapi.model.Sku;
import com.chunpat.fengxiuapi.model.User;
import com.chunpat.fengxiuapi.service.OrderService;
import com.chunpat.fengxiuapi.service.SkuService;
import com.chunpat.fengxiuapi.util.Common;
import com.chunpat.fengxiuapi.vo.OrderIdVo;
import com.chunpat.fengxiuapi.vo.OrderPureVo;
import com.chunpat.fengxiuapi.vo.OrderSimplifyVo;
import com.chunpat.fengxiuapi.vo.PagingDozer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public OrderIdVo placeOrder(@RequestBody @NotBlank OrderDto orderDto) {
        User user = LocalUser.getUser();
        List<Sku> serviceSkuList = com.chunpat.fengxiuapi.Logic.Order.getSkuList(orderDto.getSkuInfoList(), this.skuService);

        //订单检测
        PlaceOrderChecker placeOrderChecker = new PlaceOrderChecker(serviceSkuList, orderDto, this.skuMaxLimit);
        this.orderService.isOk(user.getId(), placeOrderChecker);

        //下订单
        Long orderId = this.orderService.placeOrder(user.getId(), orderDto, placeOrderChecker);

        return new OrderIdVo(orderId);
    }

    /**
     * 订单详情
     * @param orderId 订单id
     * @return OrderPureVo
     */
    @GetMapping("detail/{orderId}")
    @ScopeLevel
    public OrderPureVo getOrderDetail(@PathVariable @NotBlank Long orderId) {
        Order order = this.orderService.getDetail(LocalUser.getUser().getId(),orderId);
        return new OrderPureVo(order);
    }

    @GetMapping("by/status/{status}")
    @ScopeLevel
    public PagingDozer<Order, OrderSimplifyVo> getLatestList(
            @PathVariable Integer status,
            @RequestParam(defaultValue = "1") Integer start,
            @RequestParam(defaultValue = "10") Integer count
    ) {
        PageCounter pageCounter = Common.convertToPageParameter(start, count);
        Page<Order> orderPage = this.orderService.getByStatus(
                LocalUser.getUser().getId(),
                status,
                pageCounter.getPage(),
                pageCounter.getCount()
        );
        return new PagingDozer<>(orderPage, OrderSimplifyVo.class);
    }

    /**
     * 查询待支付
     * @param start start
     * @param count count
     * @return  PagingDozer<Order, OrderSimplifyVo>
     */
    @GetMapping("status/unpaid")
    @ScopeLevel
    public PagingDozer<Order, OrderSimplifyVo> getUnpaidList(
            @RequestParam(defaultValue = "1") Integer start,
            @RequestParam(defaultValue = "10") Integer count
    ) {
        PageCounter pageCounter = Common.convertToPageParameter(start, count);
        Page<Order> orderPage = this.orderService.getUnpaidList(
                LocalUser.getUser().getId(),
                pageCounter.getPage(),
                pageCounter.getCount()
        );
        return new PagingDozer<>(orderPage, OrderSimplifyVo.class);
    }
}
