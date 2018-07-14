package com.lourice.ein.weather.constant;

public enum Location {
    LONDON("2643743"),
    PRAGUE("3067696"),
    SAN_FRANCISCO("5391959");

    private String id;

    Location(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}
