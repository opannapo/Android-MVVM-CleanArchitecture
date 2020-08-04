package com.opannapo.mvvmexample.usecases.splash;

import android.annotation.SuppressLint;

import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;
import com.opannapo.mvvmexample.entities.User;

/**
 * Created by napouser on 04,August,2020
 */
public class SplashUseCaseImpl extends BaseUseCase<SplashUseCase.View> implements SplashUseCase.Action {

    public SplashUseCaseImpl(SplashUseCase.View view) {
        super(view);
    }


    @SuppressLint("DefaultLocale")
    @Override
    public void doGetUser(String val) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(50);
                    if (i == 100 - 1) {
                        User user = new User();
                        user.setName("OpannapO");
                        user.setAge(31);
                        view.onUserResult(user);
                    } else {
                        view.onProcessing(String.format("%d of %d", i, 100));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "THREAD_TMP"
        ).start();
    }
}
