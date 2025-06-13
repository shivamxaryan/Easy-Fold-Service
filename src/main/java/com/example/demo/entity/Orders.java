package com.example.demo.entity;

import com.example.demo.entity.Enum.OrderStatus;
import com.example.demo.entity.Enum.ServiceFulfillmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "orders")
@Entity
public class Orders extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "consumer_id", nullable = false)
    private Users consumer;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Users provider;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceCatalog service;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "fulfillment_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceFulfillmentType fulfillmentType;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    @Column(name = "scheduled_time", nullable = false)
    private String scheduledTime;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id", nullable = false)
    private Address deliveryAddress;
}