package com.opannapo.core.layer.enterprise.business.local.room;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetManyCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.User;
import com.opannapo.core.layer.interfaces.local.UserRules;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
class UserRulesImpl implements UserRules {
    @Override
    public void getOne(int id, RoomGetOneCallback callback) {

    }

    @Override
    public void getAll(List<User> users, RoomGetManyCallback callback) {

    }

    @Override
    public void getAll(List<User> users, int startIdx, int limit, RoomGetManyCallback callback) {

    }
}
