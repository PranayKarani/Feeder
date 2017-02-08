package com.example.murtuza.feeder;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.murtuza.feeder.RSS.Downloader;
import com.example.murtuza.feeder.UI.MyAdapter;
import com.example.murtuza.feeder.UI.News;
import com.example.murtuza.feeder.UI.Saved;
import com.example.murtuza.feeder.UI.Search;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final static String urlAddress = "http://feeds.feedburner.com/engadget";
    ArrayList<String> addresses = new ArrayList<String>();
    Database mydb;
    Toolbar toolbar;
    public NavigationView navigationView;
    public static FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mydb = new Database(this);
        final RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        new Downloader(MainActivity.this, urlAddress, rv).execute();
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setVisibility(View.GONE);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(MyAdapter.isSelectable==true){
            MyAdapter.isSelectable=false;
        }else {
            super.onBackPressed();
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh) {

            RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
            rv.setLayoutManager(new LinearLayoutManager(this));
            new Downloader(MainActivity.this, urlAddress, rv).execute();

            return true;
        } else {
            if (id == R.id.marks) {
                Cursor cursor = mydb.getAllData();
                if (cursor != null && cursor.getCount() > 0) {
                    Log.d("Cursor", "Not null");
                    if (cursor.moveToFirst()) {
                        Log.d("Cursor", "At First");
                        do {
                            Log.d("Value", cursor.getString(1));
                            addresses.add(cursor.getString(1));
                        } while (cursor.moveToNext());
                    }
                }
                mydb.close();
                cursor.close();
                RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
                rv.setLayoutManager(new LinearLayoutManager(this));

                Iterator iterator=addresses.iterator();
                  while(iterator.hasNext())      {
                    new Downloader(MainActivity.this, iterator.next().toString(), rv).execute();
                }
                return true;
            } else if (id == R.id.mall) {
                //startActivity(new Intent(MainActivity.this,Search2.class));
                return true;
            } else if (id == R.id.search) {
                //startActivity(new Intent(MainActivity.this,Search2.class));
                return true;
            } else if (id == R.id.settings) {
                //startActivity(new Intent(MainActivity.this,Search2.class));
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.home) {
            Toast.makeText(MainActivity.this, "Already at home", Toast.LENGTH_SHORT);

        } else if (id == R.id.saved) {
            startActivity(new Intent(MainActivity.this, Saved.class));
        } else if (id == R.id.all) {

        } else if (id == R.id.search) {
            startActivity(new Intent(MainActivity.this, Search.class));

        } else if (id == R.id.settings) {
            News.openBrowser=true;
            item.setTitle("Open in app");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
