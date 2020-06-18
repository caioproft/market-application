package com.pocs.MarketProject.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pocs.MarketProject.domain.enuns.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at" )
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "order_status")
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(Long id, LocalDateTime createdAt, OrderStatus orderStatus, User client){
        this.id = id;
        this.createdAt = createdAt;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus.getCode();
    }

    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }
}
