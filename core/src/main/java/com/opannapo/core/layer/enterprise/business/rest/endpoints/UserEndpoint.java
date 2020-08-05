package com.opannapo.core.layer.enterprise.business.rest.endpoints;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by napouser on 05,August,2020
 */
public interface UserEndpoint {
    @Headers({"Accept: application/json", "Content-Type: application/json",})
    @GET("users")
    Call<JsonObject> getAll(@Query("page") int page);

    @Headers({"Accept: application/json", "Content-Type: application/json",})
    @GET("users?per_page=20")
    Call<JsonObject> getAll();
}