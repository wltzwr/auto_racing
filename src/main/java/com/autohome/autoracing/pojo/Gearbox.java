package com.autohome.autoracing.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("gearbox")
@Data
public class Gearbox {
    private Integer id;

    private String name;

    private BigDecimal weight;

    private BigDecimal efficiency;

    private BigDecimal torque;

    private Integer shiftTime;

}