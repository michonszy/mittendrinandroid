package com.example.szymon.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toolbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.app.NotificationManager;
import android.app.PendingIntent;
import java.net.URL;
import java.util.Locale;


public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private ProgressBar progressBar;
    private DrawerLayout drawer;
    private MenuItem menuItem;

    String glowna = "https://mittendrin.pl/wydarzenia.html";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_home, container, false);

        final ProgressBar progressBar = (ProgressBar)v.findViewById(R.id.progres);


        final WebView webView = v.findViewById(R.id.websiteView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url)
            {
                view.loadUrl("javascript:document.querySelector('.post_catalog_sidebar').remove(); document.querySelector('footer').remove(); document.querySelector('.container-radio').remove(); document.querySelector('.navbar-lang').remove(); document.querySelector('.navbar-toggle').remove();");
                progressBar.setVisibility(View.GONE);
            }
        });

        //WIELOJEZYCZNOSC STRONY

        String lang = Locale.getDefault().getLanguage();

        if (lang.equals("de")) {
            glowna = "https://mittendrin.pl/de/wydarzenia.html";
        }


        webView.loadUrl(glowna);


        NavigationView navigationView = v.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





        return v;


    }






    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        WebView witrynka = getView().findViewById(R.id.websiteView);
        witrynka.loadUrl("javascript:document.querySelector('.post_catalog_sidebar').remove(); document.querySelector('footer').remove(); document.querySelector('.container-radio').remove(); document.querySelector('.navbar-lang').remove(); document.querySelector('.navbar-toggle').remove();");


        switch(menuItem.getItemId()){
            case R.id.nav_home:
                witrynka.loadUrl("https://mittendrin.pl/wydarzenia.html");
                break;
            case R.id.nav_people:
                witrynka.loadUrl("https://mittendrin.pl/wydarzenia/2/stosunki-pl-de.html");

                break;
            case R.id.nav_news:
                witrynka.loadUrl("https://mittendrin.pl/wydarzenia/1/sprawy-mniejszosci.html");
                break;
            case R.id.nav_history:
                witrynka.loadUrl("https://mittendrin.pl/wydarzenia/10/historia.html");
                break;
            case R.id.nav_culture:
                witrynka.loadUrl("https://mittendrin.pl/wydarzenia/3/kultura.html");
                break;
            case R.id.nav_tv:
                witrynka.loadUrl("https://mittendrin.pl/wydarzenia/5/hdo.html");
                break;
            case R.id.nav_microphone:
                witrynka.loadUrl("https://mittendrin.pl/wydarzenia/11/zapowiedzi.html");
                break;
            case R.id.nav_eco:
                witrynka.loadUrl("https://mittendrin.pl/wydarzenia/6/eko.html");
                break;

        }
        return false;
    }
}