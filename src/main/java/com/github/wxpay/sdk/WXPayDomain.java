package com.github.wxpay.sdk;

/**
 * 域名管理，实现主备域名自动切换
 */
public class WXPayDomain implements IWXPayDomain {

    @Override
    public void report(String domain, long elapsedTimeMillis, Exception ex) {

    }

    @Override
    public DomainInfo getDomain(WXPayConfig config) {
        return new DomainInfo(WXPayConstants.DOMAIN_API,true);
    }
}