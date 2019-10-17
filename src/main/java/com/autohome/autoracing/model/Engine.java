package com.autohome.autoracing.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Engine {
    private Integer id;

    private String name;

    private BigDecimal power;

    private BigDecimal torque;

    private BigDecimal weight;

    private BigDecimal speed;

}