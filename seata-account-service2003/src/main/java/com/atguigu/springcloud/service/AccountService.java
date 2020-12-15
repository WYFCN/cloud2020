package com.atguigu.springcloud.service;

import java.math.BigDecimal;

public interface AccountService {

    void decrease(int userId, double money);
}