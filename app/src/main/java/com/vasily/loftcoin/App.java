package com.vasily.loftcoin;

import android.app.Application;

import com.vasily.loftcoin.data.prefs.Prefs;
import com.vasily.loftcoin.data.prefs.PrefsImpl;

public class App extends Application {


    private Prefs prefs;

    @Override
    public void onCreate() {
        super.onCreate();

        prefs = new PrefsImpl(this);

    }

    public Prefs getPrefs() {
        return prefs;
    }
}