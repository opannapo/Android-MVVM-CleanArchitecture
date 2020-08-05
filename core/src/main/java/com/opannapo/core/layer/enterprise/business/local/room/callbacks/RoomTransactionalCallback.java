package com.opannapo.core.layer.enterprise.business.local.room.callbacks;

/**
 * Created by napouser on 05,August,2020
 */
public abstract class RoomTransactionalCallback {
    public abstract void onProgress(String msg);

    public abstract void onComplete(Boolean isSuccess, String error);
}
