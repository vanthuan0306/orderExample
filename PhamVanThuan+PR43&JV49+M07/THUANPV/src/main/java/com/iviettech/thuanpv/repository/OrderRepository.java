package com.iviettech.thuanpv.repository;

import com.iviettech.thuanpv.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findByNameContainingIgnoreCase(String name);
}
