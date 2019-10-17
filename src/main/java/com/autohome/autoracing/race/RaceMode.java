package com.autohome.autoracing.race;

public enum RaceMode {


    oneHundredKMPerHour("0-100km/h"),

    twoHundredKMPerHour("0-200km/h"),

    fourHundredMeters("400m"),

    eightHundredMeters("800m");

    private String modeName;

    RaceMode(String modeName){
        this.modeName = modeName;
    }
}
