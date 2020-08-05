package com.opannapo.core.config;

import android.content.Context;

/**
 * Created by napouser on 05,August,2020
 */
public class RoomDbConfig {
    Context appContext;
    String dbName;

    public Context getAppContext() {
        return appContext;
    }

    public RoomDbConfig setAppContext(Context appContext) {
        this.appContext = appContext;
        return this;
    }

    public String getDbName() {
        return dbName;
    }

    public RoomDbConfig setDbName(String dbName) {
        this.dbName = dbName;
        return this;
    }
}
