package com.chunpat.fengxiuapi.core.enumeration;

public enum OrderStatus {
    All(0,"全部"),
    UNPAID(1,"未支付"),
    PAID(2,"已支付"),
    DELIVERED(3,"已发货"),
    FINISHED(4,"已完成"),
    CANCELED(5,"已取消"),

    PAID_BUT_OUT_OF(21,"已支付，但无货或库存不足"),
    DEAL_OUT_OF(22,"已处理缺货但支付的情况");

    private int value;

    public int getValue() {
        return this.value;
    }

    OrderStatus(int value, String description){
//        int[] array = {0,1,2,3,4,5,21,22};
//        if(!Arrays.asList(array).contains(value)){
//            throw new RuntimeException("order status error");
//        }
        this.value = value;
    }

}
