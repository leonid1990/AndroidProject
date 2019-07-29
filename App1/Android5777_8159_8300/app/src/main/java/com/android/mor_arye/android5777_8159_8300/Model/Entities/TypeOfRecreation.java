package com.android.mor_arye.android5777_8159_8300.Model.Entities;

/**
 * Created by Leon on 23-Nov-16.
 */

public enum TypeOfRecreation {
    HOTEL("Hotel"),
    TRAVEL("Travel"),
    ENTERTAINMENT_SHOW("Entertainment show"),
    AIRLINE_COMPANY("Airline company"),
    OTHER("Other");

    private String typeString;
    private TypeOfRecreation(String type) {
        this.typeString = type;
    }

    @Override
    public String toString(){
        return typeString;
    }
}