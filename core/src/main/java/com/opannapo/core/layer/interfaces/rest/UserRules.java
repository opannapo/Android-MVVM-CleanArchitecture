package com.opannapo.core.layer.interfaces.rest;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetManyCallback;

/**
 * Created by napouser on 05,August,2020
 */
public interface UserRules<T> {
    void getAll(RoomGetManyCallback<T> callback);

    void getAll(int page, RoomGetManyCallback<T> callback);
}