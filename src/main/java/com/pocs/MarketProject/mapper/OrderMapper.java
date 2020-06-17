package com.pocs.MarketProject.mapper;

import com.pocs.MarketProject.domain.model.Order;
import com.pocs.MarketProject.domain.request.OrderCreateRequest;
import com.pocs.MarketProject.domain.response.OrderResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderResponse orderToOrderResponse( Order order){

        return OrderResponse.builder()
                .id(order.getId())
                .createdAt(order.getCreatedAt())
                .orderStatus(order.getOrderStatus())
                .name(order.getClient().getName())
                .email(order.getClient().getEmail())
                .phone(order.getClient().getPhone())
                .build();
    }

    public Order orderCreateRequestoToOrder (OrderCreateRequest orderCreateRequest){

        Order order = new Order();
        order.setClient(orderCreateRequest.getClient());
        order.setOrderStatus(orderCreateRequest.getOrderStatus());

        return order;
    }
}
