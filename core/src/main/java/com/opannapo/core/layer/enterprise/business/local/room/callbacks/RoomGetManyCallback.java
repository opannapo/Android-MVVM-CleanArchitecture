package com.opannapo.core.layer.enterprise.business.local.room.callbacks;

import java.util.List;

/**
 * Created by napouser on 05,August,2020
 */
public abstract class RoomGetManyCallback<T> {
    abstract void onProgress(String msg);

    abstract void onComplete(Boolean isSuccess, List<T> data, String error);
}
