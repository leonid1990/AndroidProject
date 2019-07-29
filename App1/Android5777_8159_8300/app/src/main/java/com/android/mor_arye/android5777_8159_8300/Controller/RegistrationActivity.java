package com.android.mor_arye.android5777_8159_8300.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import static com.android.mor_arye.android5777_8159_8300.Controller.LoginActivity.NAME_KEY;
import static com.android.mor_arye.android5777_8159_8300.Controller.LoginActivity.PASSWORD_KEY;
import static com.android.mor_arye.android5777_8159_8300.Controller.LoginActivity.PREFS_NAME;

/**
 * Activity to Register a new user
 */
public class RegistrationActivity extends AppCompatActivity {

//  SharedPreferences shPrefRegister;
    SharedPreferences.Editor editRegister;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    /**
     * a button to Register
     * @param view
     */
    public void onRegister(View view) {
        try
        {
            if (((TextView) findViewById(R.id.NameEdit)).getText().toString().equals("") ||
                    ((TextView) findViewById(R.id.passwordEdit)).getText().toString().equals(""))
                throw new IllegalArgumentException("You must fill all fields");
            saveToShPref();
            saveToDB();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        catch (IllegalArgumentException e)
        {
            Log.d(CustomContentProvider.CP_TAG, "in onRegister in RegistrationActivity " +  e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * save the password and name in the shared preferences
     */
    private void saveToShPref() {

        editRegister = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();

        String name = ((TextView) findViewById(R.id.NameEdit)).getText().toString();
        String pass = ((TextView) findViewById(R.id.passwordEdit)).getText().toString();

        editRegister.putString(NAME_KEY, name);
        editRegister.putString(PASSWORD_KEY, pass);
        editRegister.commit();
    }

    /**
     * save the password and name in the DB
     */
    private void saveToDB() {
        final ContentValues newUser = new ContentValues();

        newUser.put("nameUser", ((TextView) findViewById(R.id.NameEdit)).getText().toString());
        newUser.put("password", ((TextView) findViewById(R.id.passwordEdit)).getText().toString());
        try {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {

                    getContentResolver().insert(
                            Uri.parse("content://com.android.mor_arye.android5777_8159_8300/users"), newUser);

                    return null;
                }
            }.execute();
            Toast.makeText(this, "You registered successfully", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex) {
            Log.d(CustomContentProvider.CP_TAG, "in saveToDB in RegistrationActivity " +  ex.getMessage());
//            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
