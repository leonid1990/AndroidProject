package com.android.mor_arye.android5777_8159_8300_travel_finder.Model.DataSource;

import android.content.ContentValues;
import android.database.Cursor;
import android.location.Address;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.android.mor_arye.android5777_8159_8300_travel_finder.Controller.TravelsReceiver;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend.IDSManager;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Entities.Business;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Entities.Travel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static com.android.mor_arye.android5777_8159_8300_travel_finder.Controller.TravelsReceiver.CP_TAG;

/**
 * Created by mor
 */


public class ListDsManager implements IDSManager {

    public static final String LIST_DS_TAG = "ListDsManager";

    public List<Business> businesses;
    public List<Travel> travels;

    private boolean businessesUpdates = false;
    private boolean recreationsUpdates = false;

    // constructor
    public ListDsManager() {
        businesses = new ArrayList<>();
        travels = new ArrayList<>();
    }

    @Override
    public void insertBusiness(ContentValues newBusiness) {
        businessesUpdates=true;
        businesses.add(new Business(
                newBusiness.getAsInteger("idBusiness"),
                newBusiness.getAsString("nameBusiness"),
                newBusiness.getAsString("addressBusiness"),
                newBusiness.getAsString("phoneNumber"),
                newBusiness.getAsString("emailAddress"),
                newBusiness.getAsString("websiteLink")
        ));
    }

    @Override
    public void insertTravel(ContentValues newTravel) {
        recreationsUpdates = true;
        GregorianCalendar calB = strToCal(newTravel.getAsString("dateOfBeginning"));
        GregorianCalendar calE = strToCal(newTravel.getAsString("dateOfEnding"));
        travels.add(new Travel(
                newTravel.getAsString("nameOfCountry"),
                /*new GregorianCalendar(
                        new Integer(dateB.substring(6,10)),
                        new Integer(dateB.substring(3,5)),
                        new Integer(dateB.substring(0,2))),
                new GregorianCalendar(
                        new Integer(dateE.substring(6,10)),
                        new Integer(dateE.substring(3,5)),
                        new Integer(dateE.substring(0,2))),*/
                calB, calE,
                newTravel.getAsDouble("price"),
                newTravel.getAsString("description"),
                newTravel.getAsInteger("idBusiness")
        ));
    }

    // ~~~~~~~ get all collections ~~~~~~~

    @Override
    public Collection<Business> getAllBusinesses() {
        return businesses;
    }

    @Override
    public Collection<Travel> getAllTravels() {
        return travels;
    }

    @Override
    public Collection<Travel> getTravelsByCountry(String nameOfCountry) {
        HashMap<String, Collection<Travel>> hashMap = new HashMap<String, Collection<Travel>>();
        for (Travel travel: getAllTravels())
        {
            if (!hashMap.containsKey(travel.getNameOfCountry())) {
                List<Travel> list = new ArrayList<Travel>();
                list.add(travel);

                hashMap.put(travel.getNameOfCountry(), list);
            } else {
                hashMap.get(travel.getNameOfCountry()).add(travel);
            }
        }

        return hashMap.get(nameOfCountry);
    }

    @Override
    public Collection<Travel> getTravelsByBusiness(String nameOfBusiness) {
        HashMap<Integer, Collection<Travel>> hashMap = new HashMap<Integer, Collection<Travel>>();
        for (Travel travel: getAllTravels())
        {
            if (!hashMap.containsKey(travel.getIdBusiness())) {
                List<Travel> list = new ArrayList<Travel>();
                list.add(travel);

                hashMap.put(travel.getIdBusiness(), list);
            } else {
                hashMap.get(travel.getIdBusiness()).add(travel);
            }
        }

        return hashMap.get(getBusinessIdByName(nameOfBusiness));
    }

    public Integer getBusinessIdByName(String nameOfBusiness) {
        Integer result = -1;
        for (Business b : getAllBusinesses()) {
            if (b.getNameBusiness().equals(nameOfBusiness))
                result = b.getIdBusiness();
        }

        return result;
    }

    /**
     * The method coverts from string to GregorianCalendar object
     * @param strDate This is the date in a string
     * @return the date in GregorianCalendar object
     */
    public GregorianCalendar strToCal(String strDate)
    {
        Date date;
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        try{
            date = df.parse(strDate);
        }
        catch (Exception e){
            Log.d(LIST_DS_TAG, e.getMessage());
            Log.d(LIST_DS_TAG, "Setting current date.");
            Log.d(CP_TAG, "in strToCal in ListDsManager " + e.getMessage());
            date = new Date();
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal;
    }
    // ~~~~~~~~~~~~~~

}
