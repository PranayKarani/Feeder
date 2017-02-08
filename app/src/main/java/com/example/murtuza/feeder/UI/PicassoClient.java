package com.example.murtuza.feeder.UI;

import android.content.Context;
import android.widget.ImageView;

import com.example.murtuza.feeder.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Murtuza on 03-01-2017.
 */

public class PicassoClient {
    public static void downloadImage(Context c, String imageUrl, ImageView img){
        if(imageUrl!=null && imageUrl.length()>0){
            Picasso.with(c).load(imageUrl).placeholder(R.mipmap.ic_launcher).into(img);
        }else {
            Picasso.with(c).load(R.mipmap.ic_launcher).into(img);
        }

    }
}
