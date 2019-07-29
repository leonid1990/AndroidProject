package com.android.mor_arye.android5777_8159_8300.Controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.Calendar;

import com.android.mor_arye.android5777_8159_8300.Model.Backend.CustomContentProvider;
import com.android.mor_arye.android5777_8159_8300.Model.Backend.ManagerFactory;
import com.android.mor_arye.android5777_8159_8300.Model.Entities.Recreation;
import com.android.mor_arye.android5777_8159_8300.R;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TestCP_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_cp);

// insert things for example.
        addToDSWithCP();

// get a user for example
        getAllUsers();

// print a date to check if the date is working.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                GregorianCalendar date = null;
                try {
                    date = ((ArrayList<Recreation>) ManagerFactory.getDS().getAllRecreations()).get(0).getDateOfEnding();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.d(CustomContentProvider.CP_TAG,  Integer.toString(date.get(Calendar.DATE)) + "/" +Integer.toString(date.get(Calendar.MONTH)) + "/" + Integer.toString(date.get(Calendar.YEAR))) ;

                return null;
            }
        }.execute();

    }


    // insert things for example.
    private void addToDSWithCP() {
        try {

            //<editor-fold desc="Buisness">
            //~~~~~~~~~~~~~~~~~~~~ BUSINESS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            final ContentValues newBusiness = new ContentValues();
            newBusiness.put("nameBusiness", "city of david");
            newBusiness.put("addressBusiness", "king david street");
            newBusiness.put("phoneNumber", "0123456789");
            newBusiness.put("emailAddress", "exmp@gmail.com");
            newBusiness.put("websiteLink", "jct.ac.il");

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {

                    getContentResolver().insert(
                            Uri.parse("content://com.android.mor_arye.android5777_8159_8300/businesses"), newBusiness);

                    return null;
                }
            }.execute();
            //</editor-fold>

            //<editor-fold desc="Recreation">
            //~~~~~~~~~~~~~~~~~~~~ RECREATION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            final ContentValues newRecreation = new ContentValues();

            newRecreation.put("typeOfRecreation", "HOTEL");
            newRecreation.put("nameOfCountry", "israel");
            newRecreation.put("dateOfBeginning", "05/09/2016");
            newRecreation.put("dateOfEnding", "10/09/2016");
            newRecreation.put("price", 100.2);
            newRecreation.put("description", "we will have fun!");
            newRecreation.put("idBusiness", 123);

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {

                    getContentResolver().insert(
                            Uri.parse("content://com.android.mor_arye.android5777_8159_8300/recreations"), newRecreation);

                    return null;
                }
            }.execute();
            //</editor-fold>

            //<editor-fold desc="User">
            //~~~~~~~~~~~~~~~~~~~~~ USER ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            final ContentValues newUser = new ContentValues();

            newUser.put("nameUser", "arye");
            newUser.put("password", "1234");

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {

                    getContentResolver().insert(
                            Uri.parse("content://com.android.mor_arye.android5777_8159_8300/users"), newUser);

                    return null;
                }
            }.execute();
            //</editor-fold>

        }
        catch (Exception ex){
            throw ex;
        }
    }

    // print a user for example
    private void getAllUsers() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                Uri uriOfAllUsers = Uri.parse("content://com.android.mor_arye.android5777_8159_8300/users");
                Cursor result = getContentResolver().query(uriOfAllUsers,null,null,null,null);
                result.moveToFirst();
                String str = result.getString(result.getColumnIndex("nameUser"));
                Log.d(CustomContentProvider.CP_TAG, str);
                return null;
            }
        }.execute();

    }
}
