package com.opannapo.core.layer.enterprise.business.local.room;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.opannapo.core.config.RoomDbConfig;
import com.opannapo.core.layer.enterprise.business.local.room.dao.OwnerDao;
import com.opannapo.core.layer.enterprise.business.local.room.dao.UserDao;
import com.opannapo.core.layer.enterprise.business.local.room.entities.Owner;
import com.opannapo.core.layer.enterprise.business.local.room.entities.User;
import com.opannapo.core.layer.enterprise.business.local.room.exceptions.RoomConfigException;

/**
 * Created by napouser on 05,August,2020
 */
@Database(entities = {User.class, Owner.class,}, version = 1)
public abstract class RoomDB extends RoomDatabase {
    private static final String DB_NAME = "test_db";
    private static volatile RoomDB instance;
    private static RoomDbConfig config;

    public static RoomDbConfig buildConfig() {
        if (config == null) {
            config = new RoomDbConfig();
        }
        return config;
    }

    public static RoomDB getInstance() throws RoomConfigException {
        if (config == null) throw new RoomConfigException("No Initial Config");

        if (instance == null) {
            instance = create();
        }
        return instance;
    }

    public static void destroyInstance() {
        if (instance != null) {
            instance.close();
            instance = null;
        }
    }

    private static RoomDB create() {
        return Room.databaseBuilder(config.getAppContext(),
                RoomDB.class,
                DB_NAME).build();
    }

    public abstract UserDao userDao();

    public abstract OwnerDao ownerDao();
}
