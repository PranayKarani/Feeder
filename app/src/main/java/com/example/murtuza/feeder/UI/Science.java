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
public class Science extends Fragment {
    Database myDb;
    Button addsa, addsnpr, addfd, addio, addsm;


    public Science() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_science, container, false);
        myDb = new Database(getContext());

        addsa = (Button) view.findViewById(R.id.addsa);
        addsnpr = (Button) view.findViewById(R.id.addsnpr);
        addfd = (Button) view.findViewById(R.id.addfd);
        addio = (Button) view.findViewById(R.id.addio);
        addsm = (Button) view.findViewById(R.id.addsm);
        addsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("11", "http://feeds.feedburner.com/ScientificAmerican", "Technology");
                if (addsa.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addsa.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    //addtc.setTag(1);
                    addsa.setText("Add");
                    myDb.deleteData("11");
                }
            }
        });
        addsnpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("12", "http://feeds.feedburner.com/sciencenpr", "Technology");
                if (addsnpr.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addsnpr.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addsnpr.setText("Add");
                    myDb.deleteData("12");
                }
            }
        });
        addfd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("13", "http://flowingdata.com/feed", "Technology");
                if (addfd.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addfd.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addfd.setText("Add");
                    myDb.deleteData("13");
                }
            }
        });
        addio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("14", "http://feeds.feedburner.com/Io9", "Technology");
                if (addio.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addio.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addio.setText("Add");
                    myDb.deleteData("15");
                }
            }
        });
        addsm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("15", "http://www.sciencemag.org/rss/news_current.xml", "Technology");
                if (addsm.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addsm.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addsm.setText("Add");
                    myDb.deleteData("15");
                }
            }
        });

        return view;
    }

}
//http://feeds.feedburner.com/ScientificAmerican
//http://feeds.feedburner.com/sciencenpr science npr not displaying
//http://flowingdata.com/feed
//http://feeds.feedburner.com/Io9 Io9 not diplaying
//http://www.sciencemag.org/rss/news_current.xml
