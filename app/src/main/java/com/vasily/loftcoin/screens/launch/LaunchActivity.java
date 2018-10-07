package com.vasily.loftcoin.screens.launch;

import android.app.Activity;
import android.os.Bundle;

import com.vasily.loftcoin.App;
import com.vasily.loftcoin.data.prefs.Prefs;
import com.vasily.loftcoin.screens.start.StartActivity;
import com.vasily.loftcoin.screens.welcome.WelcomeActivity;

public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Prefs prefs = ((App) getApplication()).getPrefs();


        if (prefs.isFirstLaunch()) {
            WelcomeActivity.startInNewTask(this);
        } else {
            StartActivity.startInNewTask(this);
        }


    }
}
