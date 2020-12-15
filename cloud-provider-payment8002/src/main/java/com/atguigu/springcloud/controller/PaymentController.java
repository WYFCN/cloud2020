package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {
    @Autowired
    PaymentService userService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/payment")
    public List<Payment> get(){
        List<Payment> payments = userService.getUsers();
        for (Payment payment : payments) {
            payment.port=serverPort;
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
