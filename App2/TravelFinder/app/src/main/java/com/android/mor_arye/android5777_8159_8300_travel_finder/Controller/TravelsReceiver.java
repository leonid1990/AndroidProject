package com.android.mor_arye.android5777_8159_8300_travel_finder.Controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend.DsUpdater;

public class TravelsReceiver extends BroadcastReceiver {
    public static final String CP_TAG = "EntertainmentContent" ;

    public TravelsReceiver() {}
    Context c;

    @Override
    public void onReceive(final Context context, Intent intent) {
        c = context;
        if (intent.getAction().equalsIgnoreCase("com.android.mor_arye.android5777_8159_8300.newUpdates")) {
            try {
                DsUpdater.updateDS(intent.getExtras().getChar("table"), context);
            }
            catch (Exception e){
                Log.d(CP_TAG, "inside onReceive in TravelsReceiver " + e.getMessage());
                Log.d(DsUpdater.UPDATER_TAG, e.getMessage());
            }
        }
    }
    /*
        @Override
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action: " + intent.getAction() + "\n");
            sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
            String log = sb.toString();
            Log.d(UPDATER_TAG, log);
            Toast.makeText(context, log, Toast.LENGTH_LONG).show();
        }
        */
}