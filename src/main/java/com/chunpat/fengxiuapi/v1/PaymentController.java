package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.core.annotation.ScopeLevel;
import com.chunpat.fengxiuapi.lib.WxNotify;
import com.chunpat.fengxiuapi.service.WxpaymentNotifyService;
import com.chunpat.fengxiuapi.service.WxpaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    WxpaymentService wxpaymentService;

    @Autowired
    WxpaymentNotifyService wxpaymentNotifyService;

    @PostMapping("pay/order/{orderId}")
    @ScopeLevel
    public Map<String,String> wxMiniPreOrder(@PathVariable Long orderId) {
        return this.wxpaymentService.preWxMiniOrder(orderId);
    }

    /**
     * 微信小程序回调
     * @param request request
     * @param response response
     * @return
     */
    @RequestMapping("wxMini/notify")
    public String  wxMiniNotify(HttpServletRequest request, HttpServletResponse response) {
        // <xml>
        //  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>
        //  <attach><![CDATA[支付测试]]></attach>
        //  <bank_type><![CDATA[CFT]]></bank_type>
        //  <fee_type><![CDATA[CNY]]></fee_type>
        //  <is_subscribe><![CDATA[Y]]></is_subscribe>
        //  <mch_id><![CDATA[10000100]]></mch_id>
        //  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>
        //  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>
        //  <out_trade_no><![CDATA[1409811653]]></out_trade_no>
        //  <result_code><![CDATA[SUCCESS]]></result_code>
        //  <return_code><![CDATA[SUCCESS]]></return_code>
        //  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>
        //  <time_end><![CDATA[20140903131540]]></time_end>
        //  <total_fee>1</total_fee>
        //  <coupon_fee><![CDATA[10]]></coupon_fee>
        //  <coupon_count><![CDATA[1]]></coupon_count>
        //  <coupon_type><![CDATA[CASH]]></coupon_type>
        //  <coupon_id><![CDATA[10000]]></coupon_id>
        //  <trade_type><![CDATA[JSAPI]]></trade_type>
        //  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>
        //</xml>
        //1、解析流
        //2、判断是否合法
        //3、重复判断
        //4、更改状态
        InputStream inputStream;
        try {
            inputStream = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return WxNotify.fail();
        }
        String xml = WxNotify.readNotify(inputStream);
        if(!this.wxpaymentNotifyService.wxMiniOrder(xml)){
            return WxNotify.fail();
        };
        return WxNotify.success();
    }
}
