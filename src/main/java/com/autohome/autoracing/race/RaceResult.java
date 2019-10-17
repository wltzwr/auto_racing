package com.autohome.autoracing.race;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RaceResult {

    private String player;

    private Car car;

    private RaceMode mode;

    private long time;

    private BigDecimal speed;

    private BigDecimal distance;

}
