package com.example.murtuza.feeder.UI;

/**
 * Created by Murtuza on 03-01-2017.
 */

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.murtuza.feeder.MainActivity;
import com.example.murtuza.feeder.R;

public class MyViewHolder extends RecyclerView.ViewHolder  {
    TextView titleTxt, desctxt, dateTxt;
    ImageView img;
    CardView cardView;
    CheckBox checkBox;
    FloatingActionButton floatingActionButton;

    public MyViewHolder(View itemView) {
        super(itemView);
        titleTxt = (TextView) itemView.findViewById(R.id.titleTxt);
        //desctxt= (TextView) itemView.findViewById(R.id.descTxt);
        dateTxt = (TextView) itemView.findViewById(R.id.dateTxt);
        img = (ImageView) itemView.findViewById(R.id.articleImage);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
        checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        floatingActionButton=(FloatingActionButton) itemView.findViewById(R.id.floatingActionButton);


    }


}
