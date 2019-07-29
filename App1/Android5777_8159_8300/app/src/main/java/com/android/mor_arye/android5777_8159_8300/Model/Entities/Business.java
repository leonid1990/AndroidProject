package com.android.mor_arye.android5777_8159_8300.Model.Entities;

import android.location.Address;

/**
 * Created by mor on 20 2016.
 */

public class Business {
    private static int currentID = 1;
    private int idBusiness;
    private String nameBusiness;
    private String addressBusiness;
    private String phoneNumber;
    private String emailAddress;
    private String websiteLink;

    public String toString() {
        return nameBusiness;
    }

    public Business(int idBusiness,
                    String nameBusiness,
                    String addressBusiness,
                    String phoneNumber,
                    String emailAddress,
                    String websiteLink) {

        this.idBusiness = idBusiness;
        this.nameBusiness = nameBusiness;
        this.addressBusiness = addressBusiness;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.websiteLink = websiteLink;
    }

    public Business(String nameBusiness,
                    String addressBusiness,
                    String phoneNumber,
                    String emailAddress,
                    String websiteLink) {

        this.idBusiness = currentID++;
        this.nameBusiness = nameBusiness;
        this.addressBusiness = addressBusiness;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.websiteLink = websiteLink;
    }

    //<editor-fold desc="geters and seters">

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getNameBusiness() {
        return nameBusiness;
    }

    public void setNameBusiness(String nameBusiness) {
        this.nameBusiness = nameBusiness;
    }

    public String getAddressBusiness() {
        return addressBusiness;
    }

    public void setAddressBusiness(String addressBusiness) {
        this.addressBusiness = addressBusiness;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }
    //</editor-fold>
}
