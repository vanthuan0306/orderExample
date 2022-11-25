package com.iviettech.thuanpv.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int id;

    @Column(name = "orderDate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date orderDate;

    @Column(name = "customerName")
    private String name;

    @OneToMany(mappedBy = "order")
    private List<com.iviettech.thuanpv.entity.OrderDetailsEntity> orderDetails;

}