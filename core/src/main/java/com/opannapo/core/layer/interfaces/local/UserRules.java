package com.opannapo.core.layer.interfaces.local;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetManyCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.User;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
public interface UserRules<T> {
    void getOne(int id, RoomGetOneCallback<T> callback);

    void getAll(RoomGetManyCallback<T> callback);

    void getAll(int startIdx, int limit, RoomGetManyCallback<T> callback);

    void insertAll(List<User> users, RoomTransactionalCallback callback);

}
