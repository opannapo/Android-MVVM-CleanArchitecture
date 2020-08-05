package com.opannapo.core.layer.enterprise.business.local.room.callbacks;

/**
 * Created by napouser on 05,August,2020
 */
public abstract class RoomTransactionalCallback {
    abstract void onProgress(String msg);

    abstract void onComplete(Boolean isSuccess, String error);
}