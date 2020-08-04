package com.opannapo.core.layer.application.presenter.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.opannapo.core.layer.application.utils.StringRes;

/**
 * Created by napouser on 04,August,2020
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected abstract int initLayout();

    protected abstract void onCreated(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());

        onCreated(savedInstanceState);
    }

    public void showSnack(String msg, boolean isPositive) {
        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        view.setBackgroundColor(Color.parseColor(isPositive ? "#1E88E5" : "#C2185B"));

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        view.setLayoutParams(params);

        snack.show();
    }

    public void showSnack(String msg, boolean isPositive, CharSequence actionLabel, final View.OnClickListener actionClick) {
        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        view.setBackgroundColor(Color.parseColor(isPositive ? "#1E88E5" : "#C2185B"));

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.width = FrameLayout.LayoutParams.MATCH_PARENT;
        view.setLayoutParams(params);

        if (actionClick != null && actionLabel != null) {
            snack.setActionTextColor(Color.parseColor("#FFFFFF"));
            snack.setAction("Edit", actionClick);
        }

        snack.show();
    }

    public String stringInject(int res, Object... value) {
        return StringRes.inject(this, res, value);
    }

    public String stringOf(int res) {
        return StringRes.of(this, res);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void openSoftKeyboard() {
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null && view != null) imm.showSoftInput(view, 0);
    }

    protected void closeSoftKeyboard() {
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null && view != null) imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
