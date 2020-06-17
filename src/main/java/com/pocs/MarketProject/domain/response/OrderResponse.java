package com.pocs.MarketProject.domain.response;

import com.pocs.MarketProject.domain.enuns.OrderStatus;
import com.pocs.MarketProject.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private Long id;
    private LocalDateTime createdAt;
    private OrderStatus orderStatus;
    private String name;
    private String email;
    private String phone;

}
