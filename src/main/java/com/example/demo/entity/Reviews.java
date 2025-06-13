package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "reviews")
@Entity
public class Reviews extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private Users reviewer;

    @ManyToOne
    @JoinColumn(name = "reviewee_id", nullable = false)
    private Users reviewee;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "comment")
    private String comment;

}
