package com.example.murtuza.feeder.UI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.murtuza.feeder.Database;
import com.example.murtuza.feeder.Database2;
import com.example.murtuza.feeder.R;

public class News extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    WebView webView;
    final Activity activity=this;
    public static boolean openBrowser=false;
    Database2 database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("Link");
        String image=bundle.getString("Image");
        String title=bundle.getString("Title");
        database=new Database2(this);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        //final WebView wbView = (WebView) findViewById(R.id.webView);

        //wbView.getSettings().setJavaScriptEnabled(true);
        //wbView.loadUrl(url);
        //wbView.clearView();
        //wbView.measure(100, 100);
        //wbView.getSettings().setUseWideViewPort(true);
        //wbView.getSettings().setLoadWithOverviewMode(true);
        if (!openBrowser){
        webView.loadUrl( bundle.getString("Link"));}
            else{
                Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(bundle.getString("Link")));
                startActivity(browserIntent);}
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {

                activity.setProgress(progress * 100);

                if(progress == 100)
                    activity.setTitle(R.string.app_name);
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {   //if (!openBrowser){
                view.loadUrl(url);
               // return false;}
               // else{
               // Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                //startActivity(browserIntent);
                return true;
           // }
            }
        });

       /*WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // do your handling codes here, which url is the requested url
                // probably you need to open that url rather than redirect:
                //Bundle bundle = getIntent().getExtras();
                 //url = bundle.getString("Link");

                //view.loadUrl(url);
                //return true; // then it is not handled by default action
            //}
        //});*/






        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
            final Bundle bundle = getIntent().getExtras();
            String url = bundle.getString("Link");
            String image=bundle.getString("Image");
            String title=bundle.getString("Title");
            database.insert2(title,image,url);
            return true;
        } else if (id == R.id.browse) {
            final Bundle bundle = getIntent().getExtras();
            Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(bundle.getString("Link")));
            startActivity(browserIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            //startActivity(new Intent(News.this,MainActivity.class));

        } else if (id == R.id.saved) {

        } else if (id == R.id.all) {

        } else if (id == R.id.search) {
            //startActivity(new Intent(News.this,Search2.class));

        } else if (id == R.id.settings) {
            //startActivity(new Intent(News.this,Main2Activity.class));

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
