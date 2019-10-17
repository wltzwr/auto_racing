package com.autohome.autoracing.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bodywork {
    private Integer id;

    private String name;

    private BigDecimal weight;

    private BigDecimal resistance;

}