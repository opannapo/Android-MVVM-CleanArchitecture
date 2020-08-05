package com.opannapo.core.layer.interfaces.rest;

import com.opannapo.core.layer.enterprise.business.rest.callbacks.EndpointGetManyCallback;

/**
 * Created by napouser on 05,August,2020
 */
public interface UserRules<T> {
    void getAll(EndpointGetManyCallback<T> callback);

    void getAll(int page, EndpointGetManyCallback<T> callback);
}