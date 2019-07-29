package com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Entities;

import android.location.Address;

/**
 * Created by mor
 */

public class Business {
    private int idBusiness;
    private String nameBusiness;
    private String addressBusiness;
    private String phoneNumber;
    private String emailAddress;
    private String websiteLink;

    @Override
    public String toString() {
        return nameBusiness;
    }

    public Business(int idBusiness, String nameBusiness,
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

    //<editor-fold desc="geters and seters">
    //TODO get/set idBusiness? integer overflow
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
