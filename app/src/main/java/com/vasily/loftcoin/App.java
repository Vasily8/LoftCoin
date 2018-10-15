package com.vasily.loftcoin;

import android.app.Application;
import com.vasily.loftcoin.data.api.Api;
import com.vasily.loftcoin.data.api.ApiInitializer;
import com.vasily.loftcoin.data.db.Database;
import com.vasily.loftcoin.data.db.DatabaseInitializer;
import com.vasily.loftcoin.data.prefs.Prefs;
import com.vasily.loftcoin.data.prefs.PrefsImpl;


public class App extends Application {

    private Api api;
    private Prefs prefs;
    private Database database;

    @Override
    public void onCreate() {
        super.onCreate();

        prefs = new PrefsImpl(this);
        api = new ApiInitializer().init();
        database = new DatabaseInitializer().init(this);
    }

    public Prefs getPrefs() {
        return prefs;
    }


    public Api getApi() {
        return api;
    }

    public Database getDatabase() {
        return database;
    }
}