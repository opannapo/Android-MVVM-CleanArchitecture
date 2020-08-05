package com.opannapo.core.layer.enterprise.business.local.room;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.Owner;
import com.opannapo.core.layer.interfaces.local.OwnerRules;

/**
 * Created by napouser on 05,August,2020
 */
class OwnerRulesImpl implements OwnerRules {
    private static RoomDB db;

    public OwnerRulesImpl() {
        db = RoomDB.getInstance();
    }

    @Override
    public void get(RoomGetOneCallback callback) {

    }

    @Override
    public void update(Owner owner, RoomTransactionalCallback callback) {

    }
}
