package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Payment {
    public Long id;
    public String name;
    public String port;

    public Payment(Long id, String name, String port) {
        this.id = id;
        this.name = name;
        this.port = port;
    }

}
