package com.opannapo.core.layer.enterprise.business.local.room;

import android.content.Context;

import com.opannapo.core.layer.application.domain.Owner;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.interfaces.local.OwnerRules;

/**
 * Created by napouser on 05,August,2020
 */
public class OwnerRulesImpl implements OwnerRules<Owner> {
    @Override
    public void get(Context context, RoomGetOneCallback<Owner> callback) {
        new Thread(() -> {
            Owner owner = RoomDB.getInstance(context).ownerDao().get(1);
            callback.onComplete(true, owner, null);
        }, "TOwnerRulesImpl.get").start();
    }

    @Override
    public void insert(Context context, Owner owner, RoomTransactionalCallback callback) {
        callback.onProgress("insert");
        new Thread(() -> {
            RoomDB.getInstance(context).ownerDao().insert(owner);
            callback.onComplete(true, null);
        }, "TOwnerRulesImpl.insert").start();
    }

    @Override
    public void update(Context context, Owner owner, RoomTransactionalCallback callback) {
        callback.onProgress("insert");
        new Thread(() -> {
            RoomDB.getInstance(context).ownerDao().update(owner);
            callback.onComplete(true, null);
        }, "TOwnerRulesImpl.update").start();
    }
}
