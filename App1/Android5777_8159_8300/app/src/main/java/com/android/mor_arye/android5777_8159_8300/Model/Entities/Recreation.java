package com.android.mor_arye.android5777_8159_8300.Model.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by Leon on 23-Nov-16.
 */

public class Recreation {
    TypeOfRecreation typeOfRecreation;
    String nameOfCountry;
    GregorianCalendar dateOfBeginning;
    GregorianCalendar dateOfEnding;
    double price;
    String description;
    int idBusiness;

    public String toString() {
        String name = "Country: " + nameOfCountry;
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String dateOfBeginning = df.format(getDateOfBeginning().getTime());
        String dateOfEnding = df.format(getDateOfEnding().getTime());

        return name + '\n' + dateOfBeginning + '\n' + dateOfEnding + '\n'
                + getTypeOfRecreation() + '\n' + description;
    }

    public Recreation(TypeOfRecreation typeOfRecreation,
                      String nameOfCountry,
                      GregorianCalendar dateOfBeginning,
                      GregorianCalendar dateOfEnding,
                      double price,
                      String description,
                      int idBusiness) {

        this.typeOfRecreation = typeOfRecreation;
        this.nameOfCountry = nameOfCountry;
        this.dateOfBeginning = dateOfBeginning;
        this.dateOfEnding = dateOfEnding;
        this.price = price;
        this.description = description;
        this.idBusiness = idBusiness;
    }


    //<editor-fold desc="getters and setters">
    public TypeOfRecreation getTypeOfRecreation() {
        return typeOfRecreation;
    }

    public void setTypeOfRecreation(TypeOfRecreation typeOfRecreation) {
        this.typeOfRecreation = typeOfRecreation;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public GregorianCalendar getDateOfBeginning() {
        return dateOfBeginning;
    }

    public void setDateOfBeginning(GregorianCalendar dateOfBeginning) {
        this.dateOfBeginning = dateOfBeginning;
    }

    public GregorianCalendar getDateOfEnding() {
        return dateOfEnding;
    }

    public void setDateOfEnding(GregorianCalendar dateOfEnding) {
        this.dateOfEnding = dateOfEnding;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }
    //</editor-fold>
}
