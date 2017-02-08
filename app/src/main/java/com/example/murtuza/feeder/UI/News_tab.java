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
public class News_tab extends Fragment {
    Database myDb;
    Button addbb, addht, addnt, addnp, addab;


    public News_tab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_tab, container, false);
        myDb = new Database(getContext());

        addbb = (Button) view.findViewById(R.id.addbb);
        addht = (Button) view.findViewById(R.id.addht);
        addnt = (Button) view.findViewById(R.id.addnt);
        addnp = (Button) view.findViewById(R.id.addnp);
        addab = (Button) view.findViewById(R.id.addab);
        addbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("6", "http://feeds.bbci.co.uk/news/rss.xml?edition=int", "Technology");
                if (addbb.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addbb.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addbb.setText("Add");
                    myDb.deleteData("6");
                }
            }
        });
        addht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("7", "http://www.hindustantimes.com/rss/topnews/rssfeed.xml", "Technology");
                if (addht.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addht.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addht.setText("Add");
                    myDb.deleteData("7");
                }
            }
        });
        addnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("8", "http://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml", "Technology");
                if (addnt.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addnt.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addnt.setText("Add");
                    myDb.deleteData("8");
                }
            }
        });
        addnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("9", "http://dev-jbachorik.nprdev.org/rss/rss.php?id=1001", "Technology");
                if (addnp.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addnp.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addnp.setText("Add");
                    myDb.deleteData("9");
                }

            }
        });
        addab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData("10", "http://feeds.abcnews.com/abcnews/topstories", "Technology");
                if (addab.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addab.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addab.setText("Add");
                    myDb.deleteData("10");
                }
            }
        });

        return view;

    }

}
//http://feeds.bbci.co.uk/news/rss.xml?edition=int
//http://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml media content here
//http://dev-jbachorik.nprdev.org/rss/rss.php?id=1001 no images
//http://www.hindustantimes.com/rss/topnews/rssfeed.xml remove ht
//http://feeds.abcnews.com/abcnews/topstories