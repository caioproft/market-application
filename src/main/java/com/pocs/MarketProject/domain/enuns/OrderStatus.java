package com.pocs.MarketProject.domain.enuns;

import com.pocs.MarketProject.exceptions.InvalidOrderStatusException;

public enum OrderStatus {
    WAITING_PAYMENT,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELED,
    UNDER_ANALISYS;

    private int code;
//
//    private OrderStatus(int code){
//        this.code = code;
//    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new InvalidOrderStatusException("Código do status do pedido é inválido.");
    }
}
