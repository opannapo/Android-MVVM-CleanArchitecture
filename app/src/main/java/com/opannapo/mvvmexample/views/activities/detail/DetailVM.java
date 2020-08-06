package com.opannapo.mvvmexample.views.activities.detail;

import com.opannapo.core.layer.application.presenter.view.BaseViewModel;
import com.opannapo.mvvmexample.usecases.detail.DetailUseCase;
import com.opannapo.mvvmexample.usecases.detail.DetailUseCaseImpl;

/**
 * Created by napouser on 06,August,2020
 */
public class DetailVM extends BaseViewModel<DetailUseCaseImpl> implements DetailUseCase.View {
    @Override
    protected DetailUseCaseImpl initUseCase() {
        return new DetailUseCaseImpl(this);
    }
}
