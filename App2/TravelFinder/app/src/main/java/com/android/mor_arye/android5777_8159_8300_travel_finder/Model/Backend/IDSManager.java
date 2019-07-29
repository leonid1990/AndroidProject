package com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend;

import android.content.ContentValues;

import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Entities.Business;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Entities.Travel;

import java.util.Collection;

/**
 * Created by mor
 */

public interface IDSManager {
    /**
     * Insert single business record to the list of businesses in the DS
     * @param newBusiness This is the new business to add
     */
    public void insertBusiness(ContentValues newBusiness);
    /**
     * Insert single business record to the list of travels in the DS
     * @param newTravel This is the new business to add
     */
    public void insertTravel(ContentValues newTravel);

    /**
     *
     * @return List of all businesses in the DS
     */
    public Collection<Business> getAllBusinesses();
    /**
     *
     * @return List of all travels in the DS
     */
    public Collection<Travel> getAllTravels();
    /**
     *
     * @return List of all travels in the DS grouped by country
     */
    public Collection<Travel> getTravelsByCountry(String nameOfCountry);
    /**
     *
     * @return List of all travels in the DS grouped by business
     */
    public Collection<Travel> getTravelsByBusiness(String nameOfBusiness);
    /** The method gets name of business and returns its id
     * @param nameOfBusiness
     * @return The id of the business
     */
    public Integer getBusinessIdByName(String nameOfBusiness);
}
