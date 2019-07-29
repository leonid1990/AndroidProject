package com.android.mor_arye.android5777_8159_8300.Model.Backend;

import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.android.mor_arye.android5777_8159_8300.Model.DataSource.ListDsManager;
import com.android.mor_arye.android5777_8159_8300.Model.DataSource.MySQLDBManager;

/**
 * Created by mor on 26  2016.
 */
// factory singleton

public class ManagerFactory {

    private static IDSManager instance = null;

    public static IDSManager getDS(){
        if (instance == null)
//            instance = new ListDsManager();
            instance = new MySQLDBManager();

        return instance;
    }
}
