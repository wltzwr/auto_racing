package com.autohome.autoracing.race;

import com.autohome.autoracing.model.*;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Car {

    //         basepower X
    // a = ------------

    //动力增大系数
    private static final BigDecimal POWER_ADD_2WD_COEFFICIENT = BigDecimal.valueOf(2800);
    private static final BigDecimal POWER_ADD_4WD_COEFFICIENT = BigDecimal.valueOf(3000);

    //动力放大系数
    private static final BigDecimal POWER_ENLARGE_COEFFICIENT_2WD = BigDecimal.valueOf(13);
    private static final BigDecimal POWER_ENLARGE_COEFFICIENT_4WD = BigDecimal.valueOf(15);

    //阻力放大系数
    private static final BigDecimal RESISTANCE_ENLARGE_COEFFICIENT_2WD = BigDecimal.valueOf(5.5);
    private static final BigDecimal RESISTANCE_ENLARGE_COEFFICIENT_4WD = BigDecimal.valueOf(6);


    private boolean available = false;
    private Bodywork bodywork;
    private Engine engine;
    private Gearbox gearbox;
    private Wheel wheel;
    private Shaft shaft;

    private BigDecimal basePower;
    private BigDecimal totalWeight;
    private BigDecimal speed = BigDecimal.ZERO;
    private BigDecimal distance = BigDecimal.ZERO;


    public boolean test() {
        boolean available = bodywork != null
                && gearbox != null
                && engine != null
                && wheel != null;
        if (available) {
            init();
        }
        return available;
    }

    public RaceResult start(RaceMode mode){
        long time = 0;

        switch (mode){
            case oneHundredKMPerHour:
                long st = System.currentTimeMillis();
                while(speed.compareTo(BigDecimal.valueOf(100/3.6)) <= 0){
                    run();
                }
                time = System.currentTimeMillis() - st;
                break;
            case twoHundredKMPerHour:
                st = System.currentTimeMillis();
                while(speed.compareTo(BigDecimal.valueOf(200/3.6)) <= 0){
                    run();
                }
                time = System.currentTimeMillis() - st;
                break;
            case fourHundredMeters:
                st = System.currentTimeMillis();
                while(distance.compareTo(BigDecimal.valueOf(400)) <= 0){
                    run();
                }
                time = System.currentTimeMillis() - st;
                break;
            case eightHundredMeters:
                st = System.currentTimeMillis();
                while(distance.compareTo(BigDecimal.valueOf(800)) <= 0){
                    run();
                }
                time = System.currentTimeMillis() - st;
                break;
        }
        RaceResult result = new RaceResult("", this, mode, time, speed, distance);
        reset();
        return result;
    }

    private void reset() {
        speed = BigDecimal.ZERO;
        distance = BigDecimal.ZERO;
    }

    private void init(){
        totalWeight = bodywork.getWeight()
                .add(gearbox.getWeight())
                .add(engine.getWeight())
                .add(wheel.getWeight())
                .add(is4wd() ? shaft.getWeight() : BigDecimal.ZERO);
        // 扭矩 X 变速箱效率 X 动力放大系数 + 动力增大系数
        basePower = engine.getTorque()
                .multiply(gearbox.getEfficiency())
                .multiply(is4wd() ? POWER_ENLARGE_COEFFICIENT_4WD : POWER_ENLARGE_COEFFICIENT_2WD)
                .add(is4wd() ? POWER_ADD_4WD_COEFFICIENT : POWER_ADD_2WD_COEFFICIENT);
    }


    private boolean is4wd(){
        return shaft != null;
    }

    private BigDecimal getAcceleration(){
        // 阻力 = 速度 X 速度 X 车体风阻系数 X 阻力放大系数
        BigDecimal resistance = speed
                .multiply(speed)
                .multiply(bodywork.getResistance())
                .multiply(is4wd() ? RESISTANCE_ENLARGE_COEFFICIENT_4WD : RESISTANCE_ENLARGE_COEFFICIENT_2WD);
        return basePower.subtract(resistance) .divide(totalWeight, 2);
    }

    private void run(){
        BigDecimal deltaSpeed = getAcceleration().multiply(BigDecimal.valueOf(0.01)).setScale(4, BigDecimal.ROUND_HALF_UP);
        speed = speed.add(deltaSpeed);
        BigDecimal deltaDistance = speed.multiply(BigDecimal.valueOf(0.01)).setScale(4, BigDecimal.ROUND_HALF_UP);
        distance = distance.add(deltaDistance);
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {

        }
    }

}
