package com.opannapo.mvvmexample.usecases.main;

import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;

/**
 * Created by napouser on 05,August,2020
 */
public class MainUseCaseImpl extends BaseUseCase<MainUseCase.View> implements MainUseCase.Action {
    public MainUseCaseImpl(MainUseCase.View view) {
        super(view);
    }

    @Override
    public void doGetMyProfile() {

    }
}
