package com.pocs.MarketProject.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    private Long id;
    private BigDecimal value;
    private User user;
    private LocalDateTime created_at;


}
