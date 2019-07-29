package com.android.mor_arye.android5777_8159_8300_travel_finder.Controller;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend.IDSManager;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend.ManagerFactory;
import com.android.mor_arye.android5777_8159_8300_travel_finder.R;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Views.BusinessesFragment;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Views.DrawerItemCustomAdapter;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Views.ObjectDrawerItem;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Views.TravelsFragment;

import static com.android.mor_arye.android5777_8159_8300_travel_finder.Controller.TravelsReceiver.CP_TAG;
import static com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend.DsUpdater.FillUpDS;

public class MainActivity extends ActionBarActivity {
    public static IDSManager DSManager = ManagerFactory.getDS();
    // declare properties
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for proper titles
        mTitle = mDrawerTitle = getTitle();

        // initialize properties
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // create a Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        // list the drawer items
        ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[3];

        drawerItem[0] = new ObjectDrawerItem(R.drawable.ic_businesses, "Businesses");
        drawerItem[1] = new ObjectDrawerItem(R.drawable.ic_travels, "Travels");
        drawerItem[2] = new ObjectDrawerItem(R.drawable.ic_exit, "Exit");

        // Pass the folderData to our ListView adapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem);

        // Set the adapter for the list view
        mDrawerList.setAdapter(adapter);

        // set the item click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());





        // for app icon control for nav drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        if (savedInstanceState == null) {
            // on first time display view for first nav item
            selectItem(0);
        }

        if(DSManager.getAllBusinesses().isEmpty()){
            try {
                FillUpDS(this);
            } catch (Exception e) {
                Log.d(CP_TAG, "FillUpDS in onCreate in MainActivity: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // to change up caret
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }


    // navigation drawer click listener
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        // update the main content by replacing fragments

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new BusinessesFragment();
                break;
            case 1:
                fragment = new TravelsFragment();
                break;
            case 2:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
            Log.d(CP_TAG, "Error in creating fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }


/*
    public void testDS(View view)
    {
        try
        {
            Log.d(DS_TAG,"Businesses: " + DSManager.getAllBusinesses().toString() + '\n');
            Log.d(DS_TAG,"\nTravels: ");
            for (Travel r: DSManager.getAllTravels())
            {
                Log.d(DS_TAG,r.toString() + ", ");
            }
            if (DSManager.getTravelsByCountry("Afghanistan") != null) {
                Log.d(DS_TAG, "\nTravels by Afghanistan:");
                for (Travel r : DSManager.getTravelsByCountry("Afghanistan")) {
                    Log.d(DS_TAG, r + ", ");
                }
            }
            if (DSManager.getTravelsByCountry("Albania") != null) {
                Log.d(DS_TAG, "\nTravels by Albania:");
                for (Travel r : DSManager.getTravelsByCountry("Albania")) {
                    Log.d(DS_TAG, r + ", ");
                }
            }
            if (DSManager.getTravelsByBusiness("jct") != null) {
                Log.d(DS_TAG, "\nTravels by JCT:");
                for (Travel r : DSManager.getTravelsByBusiness("jct")) {
                    Log.d(DS_TAG, r + ", ");
                }
            }
            if (DSManager.getTravelsByBusiness("biu") != null) {
                Log.d(DS_TAG, "\nTravels by BIU:");
                for (Travel r : DSManager.getTravelsByBusiness("biu")) {
                    Log.d(DS_TAG, r + ", ");
                }
            }
        }
        catch (Exception ex)
        {
            Log.d(DS_TAG, ex.getMessage());
        }
    }
    */

    /*
    public int getPrefs(Context c)
    {
        sharedpreferences = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getInt(COUNT_KEY, 0);
    }
    public void savePrefs(Context c, int numOfTravels) {
        sharedpreferences = c.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(COUNT_KEY, numOfTravels);
        editor.commit();
    }
    */
}
