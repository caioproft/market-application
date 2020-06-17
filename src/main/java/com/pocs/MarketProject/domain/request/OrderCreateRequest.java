package com.pocs.MarketProject.domain.request;

import com.pocs.MarketProject.domain.enuns.OrderStatus;
import com.pocs.MarketProject.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {

    private User client;
    private OrderStatus orderStatus;
}
