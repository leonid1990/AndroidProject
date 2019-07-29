package com.android.mor_arye.android5777_8159_8300.Controller;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.mor_arye.android5777_8159_8300.Model.Backend.IDSManager;
import com.android.mor_arye.android5777_8159_8300.Model.Backend.ManagerFactory;
import com.android.mor_arye.android5777_8159_8300.Model.Entities.Business;
import com.android.mor_arye.android5777_8159_8300.Model.Entities.Recreation;
import com.android.mor_arye.android5777_8159_8300.Model.Service.CheckForUpdateService;
import com.android.mor_arye.android5777_8159_8300.R;

import static com.android.mor_arye.android5777_8159_8300.Model.Backend.CustomContentProvider.CP_TAG;

public class MainActivity extends AppCompatActivity {

    public static final String DS_TAG = "testDS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Intent checkForUpdates = new Intent(this, CheckForUpdateService.class);
            startService(checkForUpdates);

            final Button addBusiness = (Button) findViewById(R.id.addNewBusiness);
            addBusiness.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, AddBusinessActivity.class);
                    startActivity(myIntent);
                }
            });

            final Button addRecreation = (Button) findViewById(R.id.addNewRecreation);
            addRecreation.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        Intent myIntent = new Intent(MainActivity.this, AddRecreationActivity.class);
                        startActivity(myIntent);
                    }
                        catch (Exception e){
                            Log.d(CP_TAG, "in Button addRecreation in MainActivity " + e.getMessage());
                        }
                }
            });
        }
        catch (Exception e){
            Log.d(DS_TAG, "in onCreate in MainActivity " + e.getMessage());
            Log.d(CP_TAG, "in onCreate in MainActivity " + e.getMessage());
        }
/*
        final Button button = (Button) findViewById(R.id.testDS);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    testDS(v);
                }
                catch (Exception e){
                    Log.d(DS_TAG,  "in setOnClickListener in MainActivity " +  e.getMessage());
                    Log.d(CP_TAG,  "in setOnClickListener in MainActivity " +  e.getMessage());
                }
            }
        });
        */
    }

    /**
     * check the data source
     * @param view
     *//*
    public void testDS(View view)
    {
        IDSManager DSManager = ManagerFactory.getDS();

        try
        {
            Log.d(DS_TAG,"Businesses: " + DSManager.getAllBusinesses().toString() + '\n');
            Log.d(DS_TAG,"\nRecreations: ");
            for (Recreation r: DSManager.getAllRecreations())
            {
                Log.d(DS_TAG,r.toString() + ", ");
            }
        }
        catch (Exception ex)
        {
            Log.d(DS_TAG, ex.getMessage());
            Log.d(CP_TAG, "in testDS in MainActivity " +  ex.getMessage());
        }
    }
    */
}
