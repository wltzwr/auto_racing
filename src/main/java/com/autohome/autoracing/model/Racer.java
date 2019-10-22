package com.autohome.autoracing.model;

import com.autohome.autoracing.race.Car;
import lombok.Data;

@Data
public class Racer {
    private final String user;
    private final Car car;
}
