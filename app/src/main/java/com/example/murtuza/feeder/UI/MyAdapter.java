package com.example.murtuza.feeder.UI;

/**
 * Created by Murtuza on 03-01-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.murtuza.feeder.Article;
import com.example.murtuza.feeder.MainActivity;
import com.example.murtuza.feeder.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnLongClickListener {
    Context c;
    ArrayList<Article> articles;
    ArrayList<Article> selection = new ArrayList<Article>();
    public static boolean isSelectable = false;
    RecyclerView.Adapter adapter;



    public MyAdapter(Context c, ArrayList<Article> articles) {
        this.c = c;
        this.articles = articles;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.model, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Article article = articles.get(position);
        String title = article.getTitle();
        //String desc=article.getDescription();
        String date = article.getDate();
        String imageUrl = article.getImageUrl();
        holder.titleTxt.setText(title);
        //holder.desctxt.setText(desc);
        holder.dateTxt.setText(date);
        PicassoClient.downloadImage(c, imageUrl, holder.img);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(c, News.class);
                intent.putExtra("Link", article.getLink());
                intent.putExtra("Title", article.getTitle());
                intent.putExtra("Image", article.getImageUrl());
                c.startActivity(intent);
                holder.cardView.setCardBackgroundColor(Color.GRAY);


            }
        });
        MainActivity.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectable=false;
                notifyDataSetChanged();

                MainActivity.floatingActionButton.setVisibility(View.GONE);
            }
        });
        if (!isSelectable) {
            holder.checkBox.setVisibility(View.GONE);


        } else {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(false);
        }
        holder.cardView.setOnLongClickListener(this);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.checkBox.isChecked()) {
                    selection.add(articles.get(holder.getAdapterPosition()));
                    holder.cardView.setCardBackgroundColor(Color.GRAY);


                } else {
                    selection.remove(articles.get(holder.getAdapterPosition()));
                    holder.cardView.setCardBackgroundColor(Color.WHITE);

                }

            }
        });
        //holder.checkBox.setChecked(rs[position]);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @Override
    public boolean onLongClick(View v) {
        MyViewHolder holder = new MyViewHolder(v);
        holder.checkBox.setVisibility(View.VISIBLE);
        MainActivity.floatingActionButton.show();
        //if(toolbar.getMenu()!=null) {
        Log.d("asdasd", "asdasd");
        isSelectable = true;
        notifyDataSetChanged();


        //new MainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //}
        return false;
    }



}
