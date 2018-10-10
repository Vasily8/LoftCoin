package com.vasily.loftcoin;

import android.app.Application;

import com.vasily.loftcoin.data.prefs.Prefs;
import com.vasily.loftcoin.data.prefs.PrefsImpl;
import com.vasily.loftcoin.data.api.Api;
import com.vasily.loftcoin.data.api.ApiInitializer;


public class App extends Application {

    private Api api;
    private Prefs prefs;

    @Override
    public void onCreate() {
        super.onCreate();

        prefs = new PrefsImpl(this);
        api = new ApiInitializer().init();
    }

    public Prefs getPrefs() {
        return prefs;
    }


    public Api getApi() {
        return api;
    }
}