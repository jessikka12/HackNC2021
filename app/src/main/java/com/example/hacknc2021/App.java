package com.example.hacknc2021;

import android.app.Application;
import android.content.res.Resources;

public final class App extends Application {
    public static Resources res;

    @Override
    public void onCreate() {
        super.onCreate();
        res = getResources();
    }
}
