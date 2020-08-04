package com.opannapo.core.config;

/**
 * Created by napouser on 04,August,2020
 */
class LogConfig {
    private StackTraceElement[] stackTraceElements;
    private String TAG;
    public String TAG_ADDITION;
    private boolean isLogEnable;
    public boolean isWithDetailLine;
    public boolean isWithDetailCaller;


    public boolean isLogEnable() {
        return isLogEnable;
    }

    public LogConfig setLogEnable(boolean logEnable) {
        isLogEnable = logEnable;
        return this;
    }

    private StackTraceElement[] getStackTraceElements() {
        return stackTraceElements;
    }

    public void setStackTraceElements(StackTraceElement[] stackTraceElements) {
        this.stackTraceElements = stackTraceElements;
    }

    public String getTAG() {
        return TAG;
    }

    public LogConfig setTAG(String TAG) {
        this.TAG = TAG;
        return this;
    }

    private boolean isWithDetailLine() {
        return isWithDetailLine;
    }

    public LogConfig setWithDetailLine(boolean withDetailLine) {
        isWithDetailLine = withDetailLine;
        return this;
    }

    public boolean isWithDetailCaller() {
        return isWithDetailCaller;
    }

    public LogConfig setWithDetailCaller(boolean withDetailCaller) {
        isWithDetailCaller = withDetailCaller;
        return this;
    }
}
