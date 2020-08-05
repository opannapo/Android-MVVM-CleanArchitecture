package com.opannapo.core.layer.enterprise.business.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.opannapo.core.config.RoomDbConfig;
import com.opannapo.core.layer.enterprise.business.local.room.dao.OwnerDao;
import com.opannapo.core.layer.enterprise.business.local.room.dao.UserDao;
import com.opannapo.core.layer.enterprise.business.local.room.entities.Owner;
import com.opannapo.core.layer.enterprise.business.local.room.entities.User;

/**
 * Created by napouser on 05,August,2020
 */
@Database(entities = {User.class, Owner.class,}, version = 1)
public abstract class RoomDB extends RoomDatabase {
    private static final String DB_NAME = "test_db";
    private static volatile RoomDB instance;
    private static RoomDbConfig config;

    public static synchronized RoomDB getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    public static synchronized void destroyInstance() {
        if (instance != null) {
            instance.close();
            instance = null;
        }
    }

    private static RoomDB create(Context context) {
        return Room.databaseBuilder(context, RoomDB.class, DB_NAME)
                .setJournalMode(JournalMode.WRITE_AHEAD_LOGGING)
                .build();
    }

    public abstract UserDao userDao();

    public abstract OwnerDao ownerDao();
}
