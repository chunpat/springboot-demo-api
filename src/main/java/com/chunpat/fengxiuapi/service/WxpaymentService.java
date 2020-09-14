package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.core.LocalUser;
import com.chunpat.fengxiuapi.exception.ServerInnerException;
import com.chunpat.fengxiuapi.model.Order;
import com.chunpat.fengxiuapi.util.Common;
import com.chunpat.fengxiuapi.util.IpUtil;
import com.github.wxpay.sdk.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class WxpaymentService {

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.mchid}")
    private String mchid;

    @Value("${wx.key}")
    private String key;

    @Value("${wx.notifyUrl}")
    private String notifyUrl;

    @Autowired
    OrderService orderService;

    /**
     * 1、订单可否支付
     * 2、配置准备
     * 3、支付
     * @return OrderWxMiniPayVo
     */
    @Transactional
    public Map<String,String> preWxMiniOrder(Long orderId) {

        Order order = orderService.getDetail(LocalUser.getUser().getId(),orderId);
        Map<String, String> wxPayOrder;
        try {
            WXPay wxPay = this.wxPayConfig();
            Map<String, String> body = getPrePayOrderBody(order,"chunpat");
            wxPayOrder = wxPay.unifiedOrder(body);
            if(!this.isSuccessPrePay(wxPayOrder)){
                System.out.println(wxPayOrder);
                //todo 记录日志
                throw new RuntimeException("支付回调有误");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInnerException();
        }
        //更改订单prepay_id
        orderService.updatePrepayId(LocalUser.getUser().getId(),order.getId(),wxPayOrder.get("prepay_id"));
        //组合数据签名
        return this.preparePayData(wxPayOrder,this.appid,this.key);

    }

    /**
     * @return WXPay
     */
    public WXPay wxPayConfig(){
        IWXPayDomain payDomain = new WXPayDomain();
        try {
            return new WXPay(new ChunpatWXPayConfig(this.appid,this.mchid,this.key,payDomain));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerInnerException();
        }
    }

    /**
     * body
     * @param order
     * @param title
     * @return
     */
    private Map<String,String> getPrePayOrderBody(Order order, String title){
        String numString10 = RandomStringUtils.randomNumeric(6);
        String outTradeNo = order.getOrderNo() + numString10;
        Map<String, String> body = new HashMap<String, String>();
        body.put("body", title);
        body.put("out_trade_no",outTradeNo);
        body.put("openid", LocalUser.getUser().getOpenid());
        body.put("fee_type", "CNY");
        body.put("total_fee", order.getFinalTotalPrice().multiply(new BigDecimal(100)).toBigInteger().toString());
        body.put("spbill_create_ip", IpUtil.getIpAddr(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()));
        body.put("notify_url", this.notifyUrl);
        body.put("trade_type", "JSAPI");
        return body;
    }

    /**
     *
     * @param wxPrepay
     * @return
     */
    private Boolean isSuccessPrePay(Map<String, String> wxPrepay){
        if("SUCCESS".equals(wxPrepay.get("result_code")) && "OK".equals(wxPrepay.get("return_msg"))){
            return true;
        }
        return false;
    }

    /**
     * 准备支付数据
     * @param wxPrepay
     * @param appid
     * @param appkey
     * @return
     */
    private Map<String,String> preparePayData(Map<String, String> wxPrepay, String appid, String appkey) {
        Map<String,String> signData = new HashMap<>();
        signData.put("appId",appid);
        signData.put("nonceStr",wxPrepay.get("nonce_str"));
        signData.put("package","prepay_id=" + wxPrepay.get("prepay_id"));
        signData.put("signType", "HMAC-SHA256");
        signData.put("timeStamp", Common.timestamp10());

        //paySign = MD5(appId=wxd678efh567hg6787&nonceStr=5K8264ILTKCH16CQ2502SI8ZNMTM67VS&package=prepay_id=wx2017033010242291fcfe0db70013231072&signType=MD5&timeStamp=1490840662&key=qazwsxedcrfvtgbyhnujmikolp111111) = 22D9B4E54AB1950F51E0649E8810ACD6
        try {
            signData.put("paySign",WXPayUtil.generateSignature(signData,appkey, WXPayConstants.SignType.HMACSHA256));
        } catch (Exception e) {
            //todo 日志
            e.printStackTrace();
        }
        signData.remove("appId");

        return signData;
    }

}
