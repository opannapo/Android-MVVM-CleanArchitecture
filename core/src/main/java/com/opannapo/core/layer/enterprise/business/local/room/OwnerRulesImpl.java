package com.opannapo.core.layer.enterprise.business.local.room;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.Owner;
import com.opannapo.core.layer.enterprise.business.local.room.exceptions.RoomConfigException;
import com.opannapo.core.layer.interfaces.local.OwnerRules;

/**
 * Created by napouser on 05,August,2020
 */
class OwnerRulesImpl implements OwnerRules<Owner> {
    private static RoomDB db;

    public OwnerRulesImpl() {
        try {
            db = RoomDB.getInstance();
        } catch (RoomConfigException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void get(RoomGetOneCallback<Owner> callback) {
        if (db == null) {
            callback.onComplete(false, new Owner(), "No DB Initial");
            return;
        }
        callback.onComplete(true, null, null);
    }

    @Override
    public void insert(Owner owner, RoomTransactionalCallback callback) {

    }

    @Override
    public void update(Owner owner, RoomTransactionalCallback callback) {

    }
}
