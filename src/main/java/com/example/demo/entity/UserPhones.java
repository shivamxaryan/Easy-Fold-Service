package com.example.demo.entity;

import com.example.demo.entity.Enum.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "user_phones")
@Entity
public class UserPhones extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "number", unique = true, nullable = false)
    private String number;

    @Column(name = "is_primary", nullable = false)
    private boolean isPrimary = false;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
