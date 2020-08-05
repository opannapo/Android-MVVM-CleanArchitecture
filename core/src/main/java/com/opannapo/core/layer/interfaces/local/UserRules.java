package com.opannapo.core.layer.interfaces.local;

import android.content.Context;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetManyCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.application.domain.User;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
public interface UserRules<T> {
    void getOne(Context context, int id, RoomGetOneCallback<T> callback);

    void getAll(Context context, RoomGetManyCallback<T> callback);

    void getAll(Context context, int startIdx, int limit, RoomGetManyCallback<T> callback);

    void insertAll(Context context, List<User> users, RoomTransactionalCallback callback);

}
