package com.autohome.autoracing.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("engine")
@Data
public class Engine {
    private Integer id;

    private String name;

    private BigDecimal power;

    private BigDecimal torque;

    private BigDecimal weight;

    private BigDecimal speed;

}