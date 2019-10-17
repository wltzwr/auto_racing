package com.autohome.autoracing.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("player")
@Data
public class Player {
    private Integer id;

    private String playerName;

}