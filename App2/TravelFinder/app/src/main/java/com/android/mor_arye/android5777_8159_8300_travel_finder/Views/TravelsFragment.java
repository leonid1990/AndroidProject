package com.android.mor_arye.android5777_8159_8300_travel_finder.Views;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend.IDSManager;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Backend.ManagerFactory;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Entities.Business;
import com.android.mor_arye.android5777_8159_8300_travel_finder.Model.Entities.Travel;
import com.android.mor_arye.android5777_8159_8300_travel_finder.R;

import java.util.ArrayList;

/**
 * Created by Leon on 18-Mar-17.
 */

public class TravelsFragment extends ListFragment implements AdapterView.OnItemClickListener
{
    public static IDSManager DSManager = ManagerFactory.getDS();;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_travels, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<Travel> adapter = new ArrayAdapter<Travel>(
                getActivity(),
                R.layout.row_button,
                (ArrayList)DSManager.getAllTravels());
        setListAdapter(adapter);
        //getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }
}