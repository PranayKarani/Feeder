package com.example.murtuza.feeder.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.murtuza.feeder.Database;
import com.example.murtuza.feeder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Technology extends Fragment {
    Database myDb;
    Button addtc, addaa, adden, adddt, addmb;


    public Technology() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        myDb = new Database(getContext());

        addtc = (Button) view.findViewById(R.id.addtc);
        addaa = (Button) view.findViewById(R.id.addaa);
        adden = (Button) view.findViewById(R.id.adden);
        adddt = (Button) view.findViewById(R.id.adddt);
        addmb = (Button) view.findViewById(R.id.addmb);
        //addtc.setTag(1);
        addtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final int status = (Integer) v.getTag();
                if (addtc.getText().equals("Add")) {
                    boolean isInserted = myDb.insertData("1", "http://feeds.feedburner.com/TechCrunch/", "Technology");
                    if (isInserted == true)
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    addtc.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addtc.setText("Add");
                    myDb.deleteData("1");
                }
            }
        });
        addaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addtc.getText().equals("Add")) {
                    boolean isInserted = myDb.insertData("2", "http://feed.androidauthority.com/", "Technology");
                    if (isInserted == true)
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    addaa.setText("Remove");
                } else {
                    // addtc.setTag(1);
                    addaa.setText("Add");
                    myDb.deleteData("2");
                }
            }
        });
        adden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("3", "http://feeds.feedburner.com/engadget", "Technology");
                if (adden.getText().equals("Add")) {
                    if (isInserted == true){
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                }else
                    {Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();}
                    adden.setText("Remove");
                } else {
                    // addtc.setTag(1);
                    adden.setText("Add");
                    myDb.deleteData("3");
                }
            }
        });
        adddt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("4", "http://feeds.feedburner.com/DigitalTrends", "Technology");
                if (adddt.getText().equals("Add")) {
                    if (isInserted == true){
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                }else
                    {Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();}
                    adddt.setText("Remove");
                } else {
                    // addtc.setTag(1);
                    adddt.setText("Add");
                    myDb.deleteData("4");
                }
            }
        });
        addmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("5", "http://feeds.feedburner.com/Mashable", "Technology");//Replace Mashable
                if (addmb.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();}
                    addmb.setText("Remove");
                } else {
                    // addtc.setTag(1);
                    addmb.setText("Add");
                    myDb.deleteData("5");
                }
            }
        });

        return view;

    }
}


