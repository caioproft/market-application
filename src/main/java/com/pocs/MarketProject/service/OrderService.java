package com.pocs.MarketProject.service;

import com.pocs.MarketProject.domain.model.Order;
import com.pocs.MarketProject.domain.request.OrderCreateRequest;
import com.pocs.MarketProject.domain.response.OrderResponse;
import com.pocs.MarketProject.exceptions.OrderStatusNullException;
import com.pocs.MarketProject.mapper.OrderMapper;
import com.pocs.MarketProject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    OrderMapper orderMapper;

    public List<OrderResponse> findAll(){
        List<Order> orderList = orderRepository.findAll();
        List<OrderResponse> orderResponseList = new ArrayList<>();

        for(Order order : orderList){
            orderResponseList.add(orderMapper.orderToOrderResponse(order));
        }

        return orderResponseList;
    }

    public void create(OrderCreateRequest orderCreateRequest) {
        if(orderCreateRequest.getOrderStatus() == null){
            throw new OrderStatusNullException();
        }
        userService.findById(orderCreateRequest.getClient().getId());
        Order order = orderMapper.orderCreateRequestoToOrder(orderCreateRequest);
        orderRepository.save(order);
    }
}
