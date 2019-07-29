package com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by Leon on 23-Nov-16.
 */

public class Travel {
    String nameOfCountry;
    GregorianCalendar dateOfBeginning;
    GregorianCalendar dateOfEnding;
    double price;
    String description;
    int idBusiness;

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String dateOfBeginning = df.format(getDateOfBeginning().getTime());
        String dateOfEnding = df.format(getDateOfEnding().getTime());

        return "Travel to " + nameOfCountry + '\n' + dateOfBeginning + '\n' + dateOfEnding + '\n' + description;
    }

    public Travel(String nameOfCountry,
                  GregorianCalendar dateOfBeginning,
                  GregorianCalendar dateOfEnding,
                  double price,
                  String description,
                  int idBusiness) {

        this.nameOfCountry = nameOfCountry;
        this.dateOfBeginning = dateOfBeginning;
        this.dateOfEnding = dateOfEnding;
        this.price = price;
        this.description = description;
        this.idBusiness = idBusiness;
    }


    //<editor-fold desc="geters and seters">

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
