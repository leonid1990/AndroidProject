package com.android.mor_arye.android5777_8159_8300.Model.Service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.mor_arye.android5777_8159_8300.Model.Backend.IDSManager;
import com.android.mor_arye.android5777_8159_8300.Model.Backend.ManagerFactory;

import static com.android.mor_arye.android5777_8159_8300.Model.Backend.CustomContentProvider.CP_TAG;

public class CheckForUpdateService extends IntentService {
    public static final String SERVICE_TAG = "ServiceComponent";
    private static IDSManager DSManager = ManagerFactory.getDS();

    public CheckForUpdateService() {
        super("CheckForUpdatesThread");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        Log.d(CP_TAG, "service starting");
        return super.onStartCommand(intent,flags,startId);
    }

    /**
     * check every few seconds if there was updates and send broadcast
     * @param checkForUpdatesIntent
     */
    @Override
    protected void onHandleIntent(Intent checkForUpdatesIntent){
        Intent businessUpdateIntent = new Intent("com.android.mor_arye.android5777_8159_8300.newUpdates").putExtra("table",'b');
        Intent recreationUpdateIntent = new Intent("com.android.mor_arye.android5777_8159_8300.newUpdates").putExtra("table", 'r');

        while (true) {
            try {
                Thread.sleep(10000);

                if (DSManager.checkNewInBusiness()) {

                    sendBroadcast(businessUpdateIntent);
                    Toast.makeText(this, "sent update broadcast", Toast.LENGTH_SHORT).show();
                    Log.d(CP_TAG, "B3 sent broadcast business");
                }

                if (DSManager.checkNewRecreation()) {
                    sendBroadcast(recreationUpdateIntent);
                    Toast.makeText(this, "sent update broadcast", Toast.LENGTH_SHORT).show();
                    Log.d(CP_TAG, "R3 sent broadcast recreation");
                }

            } catch (InterruptedException e) {
                Log.d(SERVICE_TAG, "ERROR in Service");
                Log.d(CP_TAG, "ERROR in Service");
                Thread.currentThread().interrupt();
            }
        }
    }
/*
apparently not needed, no component will bind to the service
    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
*/
}
