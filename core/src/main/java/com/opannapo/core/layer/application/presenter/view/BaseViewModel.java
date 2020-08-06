package com.opannapo.core.layer.application.presenter.view;

import androidx.lifecycle.ViewModel;

import com.opannapo.core.layer.application.presenter.usecase.BaseUseCase;

/**
 * Created by napouser on 04,August,2020
 */
public abstract class BaseViewModel<T extends BaseUseCase<?>> extends ViewModel {
    public T useCase;

    public BaseViewModel() {
        this.useCase = initUseCase();
    }

    protected abstract T initUseCase();
}
