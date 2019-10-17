package com.autohome.autoracing;


import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Test {

    static BigDecimal speed = BigDecimal.ZERO;

    static BigDecimal distance = BigDecimal.ZERO;

    public static void main() throws InterruptedException {


        for (int i = 0; i < 3; i++) {


            long st = System.currentTimeMillis();
            while (speed.compareTo(BigDecimal.valueOf(400)) < 0){
                BigDecimal deltaSpeed = getAcceleration().multiply(BigDecimal.valueOf(0.01)).setScale(4, BigDecimal.ROUND_HALF_UP);
                speed = speed.add(deltaSpeed);
                BigDecimal deltaDistance = speed.multiply(BigDecimal.valueOf(0.01)).setScale(4, BigDecimal.ROUND_HALF_UP);
                distance = distance.add(deltaDistance);
                TimeUnit.MILLISECONDS.sleep(10);
            }
            System.out.println(System.currentTimeMillis() - st);
            System.out.println(distance);
            speed = BigDecimal.ZERO;
            distance = BigDecimal.ZERO;
        }
    }

    static BigDecimal getAcceleration(){
        return getPower().subtract(getResistance()).divide(BigDecimal.valueOf(1520),2);
    }


    static BigDecimal getResistance(){
        return speed.multiply(speed).multiply(BigDecimal.valueOf(0.25)).multiply(BigDecimal.valueOf(6));
    }


    static BigDecimal getPower(){
        return BigDecimal.valueOf(350).multiply(BigDecimal.valueOf(0.79)).multiply(BigDecimal.valueOf(15)).add(BigDecimal.valueOf(3000));
    }


}
