package com.product.product_rest.Persistance;


import com.product.product_rest.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findOrderByStatus(@Param("status") int status);
}
