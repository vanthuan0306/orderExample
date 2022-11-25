package com.iviettech.thuanpv.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orderdetails")
@Data
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "proId")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity order;
}