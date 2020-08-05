package com.opannapo.core.layer.enterprise.business.rest.callbacks;

import com.google.gson.JsonObject;

/**
 * Created by napouser on 05,August,2020
 */
public abstract class EndpointGetManyCallback<T> {
    public abstract void onProgress(String msg);

    public abstract void onComplete(Boolean isSuccess, JsonObject data, String error);
}
