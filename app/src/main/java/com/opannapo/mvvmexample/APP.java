package com.opannapo.mvvmexample;

import android.app.Application;

import com.opannapo.core.layer.enterprise.utils.Log;

/**
 * Created by napouser on 04,August,2020
 */
public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Log.buildConfig()
                    .setLogEnable(true)
                    .setWithDetailLine(true)
                    .setTAG("LOG:TEST-MVVM")
                    .setWithDetailCaller(true);
        } else {
            // TODO: 8/5/20 what ?
        }
    }
}
