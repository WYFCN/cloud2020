package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PaymentHystrixServiceImp implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentHystrixServiceImp fall back,(⊙o⊙)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentHystrixServiceImp fall back,!===!";
    }
}
