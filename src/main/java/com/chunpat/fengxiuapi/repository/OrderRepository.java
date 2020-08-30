package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

}
