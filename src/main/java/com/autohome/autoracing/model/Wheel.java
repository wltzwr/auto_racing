package com.autohome.autoracing.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Wheel {
    private Integer id;

    private String name;

    private BigDecimal weight;

    private BigDecimal traction;

}