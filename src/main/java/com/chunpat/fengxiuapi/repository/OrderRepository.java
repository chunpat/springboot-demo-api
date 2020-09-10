package com.chunpat.fengxiuapi.repository;

import com.chunpat.fengxiuapi.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findFirstByUserIdAndId(Long userId, Long id);

    @Query("select o from Order o where o.status = :status\n" +
            "and o.userId = :userId")
    Page<Order> findAllByStatus(Long userId, Integer status, Pageable page);

    @Query("select o from Order o where " +
            "o.userId = :userId")
    Page<Order> findAllByUserId(Long userId, Pageable page);

    @Query("select o from Order o where " +
            "o.userId = :userId\n" +
            "and ((o.status = 1 and o.expireTime < :now ) \n" +
            "or" +
            " o.status = 5)")//5 取消
    Page<Order> findAllUnpaid(Long userId, Date now, Pageable page);

//    @Query("select o from Order o where o.status = :status\n" +
//            "and o.userId = :user_id")
//    Paging<Order> getByStatus(Long uid, Integer status);
//
//    Paging<Order> getByStatus(Long uid, Integer status);

}
