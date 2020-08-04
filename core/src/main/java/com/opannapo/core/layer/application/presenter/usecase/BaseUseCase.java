package com.opannapo.core.layer.application.presenter.usecase;

/**
 * Created by napouser on 04,August,2020
 */
public abstract class BaseUseCase<T> {
    protected T view;

    public BaseUseCase(T view) {
        this.view = view;
    }
}