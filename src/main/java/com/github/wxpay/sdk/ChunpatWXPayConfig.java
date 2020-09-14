package com.github.wxpay.sdk;

import java.io.InputStream;

/**
 *
 */
public class ChunpatWXPayConfig extends WXPayConfig {
    private String appId;
    private String mchId;
    private String key;
    private InputStream certStream = null;
    private IWXPayDomain wxPayDomain = null;

    public ChunpatWXPayConfig(String appId, String mchId, String key,IWXPayDomain wxPayDomain) {
        this.appId = appId;
        this.mchId = mchId;
        this.key = key;
//        this.certStream = certStream;
        this.wxPayDomain = wxPayDomain;
    }

    @Override
    String getAppID() {
        return this.appId;
    }

    @Override
    String getMchID() {
        return this.mchId;
    }

    @Override
    String getKey() {
        return this.key;
    }

    @Override
    InputStream getCertStream() {
        return this.certStream;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        return this.wxPayDomain;
    }

}
