package com.opannapo.mvvmexample;

import android.app.Application;

import com.opannapo.core.layer.enterprise.business.local.room.RoomDB;
import com.opannapo.core.layer.enterprise.utils.Log;

/**
 * Created by napouser on 04,August,2020
 */
public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupLogConfig();
        setupRoomDbConfig();

    }

    void setupLogConfig() {
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

    void setupRoomDbConfig() {
        if (BuildConfig.DEBUG) {
            RoomDB.buildConfig()
                    .setAppContext(this)
                    .setDbName("dbTest_debug_mode");
        } else {
            RoomDB.buildConfig()
                    .setAppContext(this)
                    .setDbName("dbTest");
        }
    }
}
