package com.iviettech.thuanpv.repository;

import com.iviettech.thuanpv.entity.OrderDetailsEntity;
import com.iviettech.thuanpv.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderDetailRepository extends CrudRepository <OrderDetailsEntity, Integer> {

    //solution 1: use query statement
    @Transactional
    @Modifying
    @Query("select b from OrderDetailsEntity b where b.order.id = ?1")
    List<OrderDetailsEntity> getOrderDetailsByOrderId(int id);

    //solution 2: use function available of Interface CrudRepository
    //List<OrderDetailsEntity> findByOrder_Id(int id);



}
