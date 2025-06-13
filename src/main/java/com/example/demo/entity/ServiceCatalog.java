package com.example.demo.entity;

import com.example.demo.entity.Enum.ServiceFulfillmentType;
import com.example.demo.entity.Enum.ServiceName;
import com.example.demo.entity.Enum.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "service_catalog")
@Entity
public class ServiceCatalog extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "service_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceName serviceName;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "description")
    private String description;

    @Column(name="duration", nullable = false)
    private Integer duration;

    @Column(name = "fulfillment_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceFulfillmentType fulfillmentType;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

}
