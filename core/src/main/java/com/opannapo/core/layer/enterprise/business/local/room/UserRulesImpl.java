package com.opannapo.core.layer.enterprise.business.local.room;

import android.content.Context;

import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetManyCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.utils.Log;
import com.opannapo.core.layer.interfaces.local.UserRules;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
public class UserRulesImpl implements UserRules<User> {
    @Override
    public void getOne(Context context, int id, RoomGetOneCallback<User> callback) {

    }

    @Override
    public void getAll(Context context, RoomGetManyCallback<User> callback) {
        callback.onProgress("Get All");
        new Thread(() -> {
            List<User> users = RoomDB.getInstance(context).userDao().findAll();
            callback.onComplete(true, users, null);
        }, "UserRulesImpl.getAll").start();
    }

    @Override
    public void getAll(Context context, int startIdx, int limit, RoomGetManyCallback<User> callback) {

    }

    @Override
    public void insertAll(Context context, List<User> users, RoomTransactionalCallback callback) {
        callback.onProgress("Insert");
        new Thread(() -> {
            Log.d("insertAll");
            RoomDB.getInstance(context).userDao().insertAll(users);
            Log.d("insertAll done");
            callback.onComplete(true, null);
        }, "UserRulesImpl.insertAll").start();
    }
}
