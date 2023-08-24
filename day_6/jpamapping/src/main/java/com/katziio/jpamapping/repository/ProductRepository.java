package com.katziio.jpamapping.repository;

import com.katziio.jpamapping.dto.OrderResponse;
import com.katziio.jpamapping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    @Query("SELECT new com.katziio.jpamapping.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.productList p" )
    List<OrderResponse> findOrderDetails();
}