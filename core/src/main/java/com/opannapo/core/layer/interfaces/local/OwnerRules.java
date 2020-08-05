package com.opannapo.core.layer.interfaces.local;

import android.content.Context;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.Owner;

/**
 * Created by napouser on 05,August,2020
 */
public interface OwnerRules<T> {
    void get(Context context, RoomGetOneCallback<T> callback);

    void insert(Context context, Owner owner, RoomTransactionalCallback callback);

    void update(Context context, Owner owner, RoomTransactionalCallback callback);
}
