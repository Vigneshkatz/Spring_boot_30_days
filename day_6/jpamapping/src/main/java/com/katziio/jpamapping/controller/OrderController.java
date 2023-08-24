package com.katziio.jpamapping.controller;


import com.katziio.jpamapping.dto.OrderRequest;
import com.katziio.jpamapping.dto.OrderResponse;
import com.katziio.jpamapping.entity.Customer;
import com.katziio.jpamapping.repository.CustomerRepository;
import com.katziio.jpamapping.repository.ProductRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest)
    {
        return  this.customerRepository.save(orderRequest.getCustomer());
    }
    @GetMapping("/getOrder")
    public List<Customer> getOrderLists()
    {
        return this.customerRepository.findAll();
    }

    @GetMapping("/getOrderDetails")
    public List<OrderResponse> getOrderDetails(){
        return this.productRepository.findOrderDetails();
    }
}
