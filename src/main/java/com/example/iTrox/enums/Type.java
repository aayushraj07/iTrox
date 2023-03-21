package com.example.iTrox.enums;

public enum Type {

    COMMERCIAL("COMMERICAL"),
    GOVERMENT("GOVERMENT");

    private final String type;

    Type(String type){this.type = type;}

    public String getType(){
        return type;
    }
}
