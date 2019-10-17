package com.autohome.autoracing.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("shaft")
@Data
public class Shaft {

    private Integer id;
    private String name;
    private BigDecimal weight;
    private BigDecimal efficiency;
}
