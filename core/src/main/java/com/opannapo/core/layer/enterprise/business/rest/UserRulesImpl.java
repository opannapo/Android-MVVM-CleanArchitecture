package com.opannapo.core.layer.enterprise.business.rest;

import com.google.gson.JsonObject;
import com.opannapo.core.layer.enterprise.business.rest.callbacks.EndpointGetManyCallback;
import com.opannapo.core.layer.enterprise.business.rest.endpoints.UserEndpoint;
import com.opannapo.core.layer.interfaces.rest.UserRules;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by napouser on 05,August,2020
 */
public class UserRulesImpl implements UserRules<JsonObject> {
    UserEndpoint endpoint;

    public UserRulesImpl() {
        endpoint = ApiClient.getClient().create(UserEndpoint.class);
    }

    @Override
    public void getAll(EndpointGetManyCallback<JsonObject> callback) {
        callback.onProgress("Loading");
        endpoint.getAll().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                callback.onComplete(true, response.body(), null);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                callback.onComplete(false, null, t.getMessage());
            }
        });
    }

    @Override
    public void getAll(int page, EndpointGetManyCallback<JsonObject> callback) {

    }
}
