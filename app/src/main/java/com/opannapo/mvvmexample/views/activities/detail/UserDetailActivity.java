package com.opannapo.mvvmexample.views.activities.detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.opannapo.core.layer.application.domain.User;
import com.opannapo.core.layer.application.presenter.view.BaseActivity;
import com.opannapo.mvvmexample.R;
import com.opannapo.mvvmexample.etc.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by napouser on 06,August,2020
 */
public class UserDetailActivity extends BaseActivity {
    @BindView(R.id.imgProfile)
    ImageView imgProfile;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtFirstName)
    TextView txtFirstName;
    @BindView(R.id.txtLastName)
    TextView txtLastName;

    User user;

    @Override
    public Class initVM() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.user_detail_activity;
    }

    @Override
    protected void onCreated(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        if (getIntent().hasExtra(Constant.IntentExtraKey.USER_DETIAL)) {
            user = getIntent().getParcelableExtra(Constant.IntentExtraKey.USER_DETIAL);
            txtEmail.setText(user.getEmail());
            txtFirstName.setText(user.getFirstName());
            txtLastName.setText(user.getLastName());
            Glide.with(this)
                    .load(user.getAvatar())
                    .centerCrop()
                    .error(R.drawable.baseline_aspect_ratio_black_18dp)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .thumbnail(0.1f)
                    .circleCrop()
                    .into(imgProfile);
        } else {
            finish();
        }
    }
}
