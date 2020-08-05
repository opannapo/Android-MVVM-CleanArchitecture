package com.opannapo.core.layer.interfaces.local;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetManyCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.User;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
public interface UserRules {
    void getOne(int id, RoomGetOneCallback callback);

    void getAll(List<User> users, RoomGetManyCallback callback);

    void getAll(List<User> users, int startIdx, int limit, RoomGetManyCallback callback);

}
