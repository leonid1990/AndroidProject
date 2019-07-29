package com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend;

import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.DataSource.ListDsManager;

/**
 * Created by Leon on 09-Feb-17.
 * FactoyMethod design pattern combined with Singleton
 */

public class ManagerFactory {
    private static IDSManager instance = null;

    public static IDSManager getDS(){
        if (instance == null)
            instance = new ListDsManager();

        return instance;
    }
}
