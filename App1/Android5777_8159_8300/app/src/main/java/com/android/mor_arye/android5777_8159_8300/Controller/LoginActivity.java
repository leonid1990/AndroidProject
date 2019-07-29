package com.android.mor_arye.android5777_8159_8300.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mor_arye.android5777_8159_8300.Model.Backend.CustomContentProvider;
import com.android.mor_arye.android5777_8159_8300.R;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView name;
    TextView password;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String NAME_KEY = "nameKey";
    public static final String PASSWORD_KEY = "passwordKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (TextView) findViewById(R.id.etUserName);
        password = (TextView) findViewById(R.id.etPassword);
        getPrefs();
    }

    /**
     * save the password and name in the shared preferences
     */
    public void savePrefs() {
        sharedpreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String n = name.getText().toString();
        String p = password.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(NAME_KEY, n);
        editor.putString(PASSWORD_KEY, p);
        editor.commit();
    }

    /**
     * delete the password and name from the shared preferences
     */
    public void deletePrefs() {
        sharedpreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove(NAME_KEY);
        editor.remove(PASSWORD_KEY);
        editor.apply();
    }

    /**
     * erase the text
     */
    public void clearTextViews() {
        name = (TextView) findViewById(R.id.etUserName);
        password = (TextView) findViewById(R.id.etPassword);
        name.setText("");
        password.setText("");

    }

    /**
     * get the password and name from the shared preferences
     */
    public void getPrefs() {
        sharedpreferences = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(NAME_KEY)) {
            name.setText(sharedpreferences.getString(NAME_KEY, ""));
        }
        if (sharedpreferences.contains(PASSWORD_KEY)) {
            password.setText(sharedpreferences.getString(PASSWORD_KEY, ""));
        }
    }

    /**
     * to register new user button
     * @param view
     */
    public void onRegister(View view) {
        Intent myIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(myIntent);
    }

    /**
     * a log in button
     * @param view
     */
    public void onLogin(View view) {
        if (name.getText().toString().equals("") || password.getText().toString().equals("")) {
            Toast.makeText(LoginActivity.this, "Enter user name and password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (name.getText().toString().equals(sharedpreferences.getString(NAME_KEY, "")) &&
                    password.getText().toString().equals(sharedpreferences.getString(PASSWORD_KEY, "")))
            {
                savePrefs();
                Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
            else
                Toast.makeText(LoginActivity.this, "user doesn't exist", Toast.LENGTH_SHORT).show();
        }
    }
/*
    //  Old login with user and password verification

    public void onLogin(View view) {

        new AsyncTask<String, Void, Cursor>() {
            @Override
            protected void onPreExecute(){

                if (name.getText().toString().equals("") || password.getText().toString().equals("")) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(LoginActivity.this, "Enter user name and password", Toast.LENGTH_SHORT).show();
                        }
                    });

                    cancel(true);
                }
            }
            @Override
            protected Cursor doInBackground(String... name) {

                Uri uriOfAllUsers = Uri.parse("content://com.android.mor_arye.android5777_8159_8300/users");
                Cursor result = getContentResolver().query(uriOfAllUsers, null, null, null, null, null);
                return result;
            }

            @Override
            protected void onPostExecute(Cursor result) {

                boolean found = false;
                int position = -1;
                while (result.moveToNext() && !found) {
                    if (result.getString(1).equals(name.getText().toString())) {
                        found = true;
                        position = result.getPosition();
                    }
                }
                if (!found)
                {
                    Log.d(CustomContentProvider.CP_TAG, "user doesn't exist");
                    runOnUiThread(new Runnable() {
                        public void run() {Toast.makeText(LoginActivity.this, "User doesn't exist", Toast.LENGTH_SHORT).show();}});
                    clearTextViews();
                    deletePrefs();  // if there was such user, he's already doesn't exist
                }
                else
                {
                    result.moveToPosition(position);
                    if (!password.getText().toString().equals(result.getString(2)))
                    {
                        runOnUiThread(new Runnable() {
                            public void run() {Toast.makeText(LoginActivity.this, "Password is wrong", Toast.LENGTH_SHORT).show();}});
                        Log.d(CustomContentProvider.CP_TAG, "password is wrong");
                        clearTextViews();
                        deletePrefs();  // delete old prefs, password has changed
                    }
                    else
                    {
                        savePrefs();
                        Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(myIntent);
                    }
                }
                result.close();
            }
        }.execute(name.getText().toString());
    }
/*
    /*
           temporary
            */
    /*private void init() {


        //region User
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
        //endregion

        //region Business
        //~~~~~~~~~~~~~~~~~~~~ BUSINESS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ContentValues newBusiness = new ContentValues();
        newBusiness.put("nameBusiness", "city of david");
        newBusiness.put("addressBusiness", "king david street");
        newBusiness.put("phoneNumber", "0123456789");
        newBusiness.put("emailAddress", "exmp@gmail.com");
        newBusiness.put("websiteLink", "jct.ac.il");

        final ContentValues finalNewBusiness = newBusiness;
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                getContentResolver().insert(
                        Uri.parse("content://com.android.mor_arye.android5777_8159_8300/businesses"), finalNewBusiness);

                return null;
            }
        }.execute();

        newBusiness = new ContentValues();
        newBusiness.put("nameBusiness", "JCT");
        newBusiness.put("addressBusiness", "Hvaad hleomi 21");
        newBusiness.put("phoneNumber", "999999999");
        newBusiness.put("emailAddress", "new@hot.com");
        newBusiness.put("websiteLink", "jct.ac.il");

        final ContentValues finalNewBusiness1 = newBusiness;
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {

                getContentResolver().insert(
                        Uri.parse("content://com.android.mor_arye.android5777_8159_8300/businesses"), finalNewBusiness1);

                return null;
            }
        }.execute();
        //endregion

        //region Recreation
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
        //endregion

    }*/
}