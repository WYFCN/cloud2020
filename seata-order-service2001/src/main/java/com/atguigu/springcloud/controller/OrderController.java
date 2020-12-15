package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.util.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    IdGeneratorSnowflake idGeneratorSnowflake;
    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    @SentinelResource(value = "create",fallback = "fallback",blockHandler = "blockHandler")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

    public CommonResult fallback(Order order){
        return new CommonResult(500,"由于降级，您的订单创建失败");
    }
    public CommonResult blockHandler(Order order, BlockException exception){
        return new CommonResult(500,exception.getMessage());
    }
    /**
     * 生成id,通过雪花算法
     *
     * @return
     */
    @GetMapping("/snowflake")
    public String getIDBySnowflake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }
}