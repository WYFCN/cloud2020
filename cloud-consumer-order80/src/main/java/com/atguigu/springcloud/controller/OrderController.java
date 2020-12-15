package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {
    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE/";
    @Autowired
    RestTemplate restTemplate;
    @GetMapping(value = "/order")
    public List<Payment> getPayments(){
        return restTemplate.getForObject(PAYMENT_URL+"payment",List.class);
    }
}
