package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/feign")
    public List<Payment> get(){
        return paymentFeignService.get();
    }
}
