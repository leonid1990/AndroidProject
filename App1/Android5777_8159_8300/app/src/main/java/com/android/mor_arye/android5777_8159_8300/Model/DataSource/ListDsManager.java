package com.android.mor_arye.android5777_8159_8300.Model.DataSource;

import android.content.ContentValues;
import android.location.Address;
import android.util.Log;

import com.android.mor_arye.android5777_8159_8300.Model.Backend.CustomContentProvider;
import com.android.mor_arye.android5777_8159_8300.Model.Backend.IDSManager;
import com.android.mor_arye.android5777_8159_8300.Model.Entities.Recreation;
import com.android.mor_arye.android5777_8159_8300.Model.Entities.Business;
import com.android.mor_arye.android5777_8159_8300.Model.Entities.TypeOfRecreation;
import com.android.mor_arye.android5777_8159_8300.Model.Entities.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by mor on 26  2016.
 */


public class ListDsManager implements IDSManager {

    public List<User> users;
    public List<Business> businesses;
    public List<Recreation> recreations;

    private boolean usersUpdates = false;
    private boolean businessesUpdates = false;
    private boolean recreationsUpdates =    false;

    /**
     * constructor
     */
    public ListDsManager() {
        users = new ArrayList<>();
        businesses = new ArrayList<>();
        recreations = new ArrayList<>();
    }


    // ~~~~~~ insert ~~~~~~

    /**
     * insert user
     * @param newUser
     */
    @Override
    public void insertUser(ContentValues newUser) {
        users.add(new User(
                newUser.getAsString("nameUser"),
                newUser.getAsString("password")
        ));
        usersUpdates =true;
    }

    /**
     * insert business
     * @param newBusiness
     */
    @Override
    public void insertBusiness(ContentValues newBusiness) {
        businesses.add(new Business(
                newBusiness.getAsString("nameBusiness"),
                newBusiness.getAsString("addressBusiness"),
                newBusiness.getAsString("phoneNumber"),
                newBusiness.getAsString("emailAddress"),
                newBusiness.getAsString("websiteLink")
        ));
        businessesUpdates=true;
    }

    /**
     * insert Recreation
     * @param newRecreation
     */
    @Override
    public void insertRecreation(ContentValues newRecreation) {
        GregorianCalendar calB = new GregorianCalendar();
        GregorianCalendar calE = new GregorianCalendar();
        try {
            calB = strToCal(newRecreation.getAsString("dateOfBeginning"));
            calE = strToCal(newRecreation.getAsString("dateOfEnding"));
        }
        catch (Exception e)
        {
            Log.d("Date error", e.getMessage());
        }
        recreations.add(new Recreation(
                TypeOfRecreation.valueOf(newRecreation.getAsString("typeOfRecreation")),
                newRecreation.getAsString("nameOfCountry"),
                    /*new GregorianCalendar(
                            new Integer(strDateB.substring(6,10)),
                            new Integer(strDateB.substring(3,5)),
                            new Integer(strDateB.substring(0,2))),
                    new GregorianCalendar(
                            new Integer(strDateE.substring(6,10)),
                            new Integer(strDateE.substring(3,5)),
                            new Integer(strDateE.substring(0,2))),*/
                calB, calE,
                (newRecreation.getAsDouble("price")),
                newRecreation.getAsString("description"),
                newRecreation.getAsInteger("idBusiness")
        ));
        recreationsUpdates = true;
    }
    // ~~~~~~~~~~~~~~~~~

    /**
     * check if there is a new business
     * @return
     */
    @Override
    public boolean checkNewInBusiness() {
        if (businessesUpdates)
        {
            businessesUpdates = false;
            return true;
        }

        return false;
    }

    /**
     * check if there is a new recreation
     * @return
     */
    @Override
    public boolean checkNewRecreation() {
        if (recreationsUpdates)
        {
            recreationsUpdates = false;
            return true;
        }
        return false;
    }


    // ~~~~~~~ get all collections ~~~~~~~

    /**
     * get all the users
     * @return
     */
    @Override
    public Collection<User> getAllUsers() {
        return users;
    }

    /**
     * get all the businesses
     * @return
     */
    @Override
    public Collection<Business> getAllBusinesses() {
        return businesses;
    }

    /**
     * get all the recreations
     * @return
     */
    @Override
    public Collection<Recreation> getAllRecreations() {
        return recreations;
    }
    // ~~~~~~~~~~~~~~

    /**
     * convert string to calendar
     * @param strDate
     * @return
     * @throws Exception
     */
    public GregorianCalendar strToCal(String strDate) throws Exception
    {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = df.parse(strDate);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal;
    }
//    @Override
//    public void checkChanges() {    }
}
