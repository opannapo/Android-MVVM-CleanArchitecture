package com.opannapo.mvvmexample.usecases.main;

import android.os.Handler;

import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;
import com.opannapo.mvvmexample.entities.User;

/**
 * Created by napouser on 04,August,2020
 */
public class MainUseCaseImpl extends BaseUseCase<MainUseCase.View> implements MainUseCase.Action {

    public MainUseCaseImpl(MainUseCase.View view) {
        super(view);
    }


    @Override
    public void doGetUser(String val) {
        view.onProcessing();
        new Handler().postDelayed(() -> {
            User user = new User();
            user.setName("OpannapO");
            user.setAge(31);
            view.onUserResult(user);
        }, 2000);
    }
}
