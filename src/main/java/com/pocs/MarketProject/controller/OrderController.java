package com.pocs.MarketProject.controller;

import com.pocs.MarketProject.domain.request.OrderCreateRequest;
import com.pocs.MarketProject.domain.response.OrderResponse;
import com.pocs.MarketProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll(){
        List<OrderResponse> orderResponseList = orderService.findAll();
        return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OrderCreateRequest orderCreateRequest){
        orderService.create(orderCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
