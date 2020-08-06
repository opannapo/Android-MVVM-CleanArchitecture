package com.opannapo.mvvmexample.usecases.detail;

import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;

/**
 * Created by napouser on 06,August,2020
 */
public class DetailUseCaseImpl extends BaseUseCase<DetailUseCase.View> implements DetailUseCase.Action {
    public DetailUseCaseImpl(DetailUseCase.View view) {
        super(view);
    }
}
