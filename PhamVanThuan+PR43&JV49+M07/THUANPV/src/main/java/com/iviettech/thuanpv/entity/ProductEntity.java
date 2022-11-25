package com.iviettech.thuanpv.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proId")
    private int id;

    @Column(name = "proName", length = 100)
    private String name;

    @Column
    private double unitPrice;

    @OneToMany(mappedBy = "product")
    private List<OrderDetailsEntity> orderDetails;

}