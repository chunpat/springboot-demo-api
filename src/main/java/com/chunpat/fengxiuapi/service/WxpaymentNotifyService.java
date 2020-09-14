package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.model.Order;
import com.chunpat.fengxiuapi.repository.OrderRepository;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class WxpaymentNotifyService {

    @Value("${wx.key}")
    private String key;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    WxpaymentService wxpaymentService;

    /**
     * @param xml
     */
    @Transactional
    public Boolean wxMiniOrder(String xml) {
        //xml to map
        Map<String, String> map;
        try {
            map =  WXPayUtil.xmlToMap(xml);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        //返回状态
        if(!map.get("return_code").equals("SUCCESS") || !map.get("result_code").equals("SUCCESS")){
            return false;
        }

        //合法性
        WXPay wxPayConfig = this.wxpaymentService.wxPayConfig();
        try {
            wxPayConfig.isResponseSignatureValid(map);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        //处理数据
        String order = map.get("out_trade_no").substring(0,15);
        Optional<Order> orderOptional = this.orderRepository.findFirstByOrderNo(order);
        if(!orderOptional.isPresent()){
            return false;
        }

        if(this.orderRepository.updatePaidStatus(orderOptional.get().getId()) != 1){
            return false;
        };
        return true;
    }

}
