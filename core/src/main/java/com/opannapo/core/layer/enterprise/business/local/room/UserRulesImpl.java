package com.opannapo.core.layer.enterprise.business.local.room;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetManyCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.User;
import com.opannapo.core.layer.interfaces.local.UserRules;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
class UserRulesImpl implements UserRules<User> {
    @Override
    public void getOne(int id, RoomGetOneCallback<User> callback) {

    }

    @Override
    public void getAll(RoomGetManyCallback<User> callback) {

    }

    @Override
    public void getAll(int startIdx, int limit, RoomGetManyCallback<User> callback) {

    }

    @Override
    public void insertAll(List<User> users, RoomTransactionalCallback callback) {

    }
}
