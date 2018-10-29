package com.vasily.loftcoin.data.db;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class DatabaseInitializer {

    public void init(Context context) {
        Realm.init(context); //initialize realm

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .schemaVersion(1) // database version
                .name("loftcoin.realm")  //database name
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
