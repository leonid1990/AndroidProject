package com.android.mor_arye.android5777_8159_8300.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mor_arye.android5777_8159_8300.Model.Backend.CustomContentProvider;
import com.android.mor_arye.android5777_8159_8300.R;

public class AddBusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business);
    }

    /**
     * on pressing the add new business button
     * @param view
     */
    public void onAddBusiness(View view) {
        TextView name, address, phone, email, website;
        name = (EditText) findViewById(R.id.etNameOfBusiness);
        address = (EditText) findViewById(R.id.etAddressOfBusiness);
        phone = (EditText) findViewById(R.id.etPhoneNumber);
        email = (EditText) findViewById(R.id.etEmail);
        website = (EditText) findViewById(R.id.etWebSite);
        final ContentValues newBusiness = new ContentValues();
        try {
            if (name.getText().toString().equals(""))
                throw new IllegalArgumentException("You must fill at least a name");
            newBusiness.put("nameBusiness", name.getText().toString());
            newBusiness.put("addressBusiness", address.getText().toString());
            newBusiness.put("phoneNumber", phone.getText().toString());
            newBusiness.put("emailAddress", email.getText().toString());
            newBusiness.put("websiteLink", website.getText().toString());

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {

                    getContentResolver().insert(
                            Uri.parse("content://com.android.mor_arye.android5777_8159_8300/businesses"), newBusiness);

                    return null;
                }
            }.execute();
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Message");
            alertDialog.setMessage("Business added successfully!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        catch (IllegalArgumentException e)
        {
            Log.d(CustomContentProvider.CP_TAG, "in onAddBusiness in AddBusinessActivity " + e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
