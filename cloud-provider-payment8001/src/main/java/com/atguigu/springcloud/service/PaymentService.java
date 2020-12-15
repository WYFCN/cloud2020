package com.atguigu.springcloud.service;

import com.atguigu.springcloud.Dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentMapper paymentMapper;
    public List<Payment> getUsers(){
        return paymentMapper.getPayments();
    }
    public Payment getPaymentById(Integer id){
        return paymentMapper.getPaymentById(id);
    }
}
