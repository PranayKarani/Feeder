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
public class Comics extends Fragment {
    Database myDb;
    Button addxk,addom,addgmac,addtis,addpj;

    public Comics() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_comics, container, false);
        myDb=new Database(getContext());

        addxk= (Button) view.findViewById(R.id.addxk);
        addom= (Button) view.findViewById(R.id.addom);
        addgmac= (Button) view.findViewById(R.id.addgmac);
        addtis= (Button) view.findViewById(R.id.addtis);
        addpj= (Button) view.findViewById(R.id.addpj);
        addxk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=myDb.insertData("16","https://xkcd.com/rss.xml","Technology");
                if (addxk.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addxk.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addxk.setText("Add");
                    myDb.deleteData("16");
                }
            }
        });
        addom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=myDb.insertData("17","http://theoatmeal.com/feed/rss","Technology");
                if (addom.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addom.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addom.setText("Add");
                    myDb.deleteData("17");
                }
            }
        });
        addgmac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=myDb.insertData("18","http://thegentlemansarmchair.com/feed/","Technology");
                if (addgmac.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addgmac.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addgmac.setText("Add");
                    myDb.deleteData("18");
                }
            }
        });
        addtis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=myDb.insertData("19","http://feeds.feedburner.com/ThingsInSquares","Technology");
                if (addtis.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addtis.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addtis.setText("Add");
                    myDb.deleteData("19");
                }
            }
        });
        addpj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=myDb.insertData("20","http://feeds.feedburner.com/Pidjin","Technology");
                if (addpj.getText().equals("Add")) {
                    if (isInserted == true) {
                        Toast.makeText(getContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                    addpj.setText("Remove");
                    //addtc.setTag(0);
                } else {
                    // addtc.setTag(1);
                    addpj.setText("Add");
                    myDb.deleteData("20");
                }
            }
        });

        return view;
    }

}
//https://xkcd.com/rss.xml weird 4 feeds
//http://theoatmeal.com/feed/rss
//http://thegentlemansarmchair.com/feed/
//http://feeds.feedburner.com/ThingsInSquares problem with images & content encoded here
//https://axbymag.wordpress.com/category/comics/feed/ image not working img in description
//http://feeds.feedburner.com/Pidjin  same as things in square