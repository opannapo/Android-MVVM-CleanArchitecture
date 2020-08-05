package com.opannapo.core.layer.interfaces.local;

import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomGetOneCallback;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.local.room.entities.Owner;

/**
 * Created by napouser on 05,August,2020
 */
public interface OwnerRules {
    void get(RoomGetOneCallback callback);

    void update(Owner owner, RoomTransactionalCallback callback);
}
