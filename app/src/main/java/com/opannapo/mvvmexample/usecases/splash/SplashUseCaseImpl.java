package com.opannapo.mvvmexample.usecases.splash;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;
import com.opannapo.core.layer.enterprise.business.local.room.callbacks.RoomTransactionalCallback;
import com.opannapo.core.layer.enterprise.business.rest.UserRulesImpl;
import com.opannapo.core.layer.enterprise.business.rest.callbacks.EndpointGetManyCallback;
import com.opannapo.core.layer.interfaces.rest.UserRules;

import java.util.List;

/**
 * Created by napouser on 04,August,2020
 */
public class SplashUseCaseImpl extends BaseUseCase<SplashUseCase.View> implements SplashUseCase.Action {
    com.opannapo.core.layer.interfaces.local.UserRules<User> userLocal = new com.opannapo.core.layer.enterprise.business.local.room.UserRulesImpl();
    UserRules<JsonObject> userRemote = new UserRulesImpl();

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public SplashUseCaseImpl(SplashUseCase.View view) {
        super(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void doSync(Context context) {
        view.onProcessing("Prepare Sync");
        userRemote.getAll(new EndpointGetManyCallback<JsonObject>() {
            @Override
            public void onProgress(String msg) {
                view.onProcessing("Request Data");
            }

            @Override
            public void onComplete(Boolean isSuccess, JsonObject data, String error) {
                if (isSuccess) {
                    if (data.has("data") && data.get("data") instanceof JsonArray) {
                        List<User> users = gson.fromJson(data.getAsJsonArray("data"), new TypeToken<List<User>>() {
                        }.getType());

                        userLocal.insertAll(context, users, new RoomTransactionalCallback() {
                            @Override
                            public void onProgress(String msg) {
                                view.onProcessing("Insert Data");
                            }

                            @Override
                            public void onComplete(Boolean isSuccess, String error) {
                                view.onSyncResult("Completed");
                            }
                        });
                    } else {
                        view.onSyncResult("Completed");
                    }
                }
            }
        });
    }
}
