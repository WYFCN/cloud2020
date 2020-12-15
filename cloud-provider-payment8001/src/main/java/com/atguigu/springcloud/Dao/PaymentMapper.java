package com.atguigu.springcloud.Dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaymentMapper {
    @Select("select * from test")
    public List<Payment> getPayments();

    @Select("select * from test where id=#{id}")
    public Payment getPaymentById(Integer id);
}
