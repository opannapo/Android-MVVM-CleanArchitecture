package com.opannapo.core.layer.enterprise.utils;

import com.opannapo.core.config.LogConfig;

/**
 * Created by napouser on 04,August,2020
 */
public class Log {
    private static LogConfig config;

    private static boolean init() {
        if (config == null) return false;

        if (config.isLogEnable()) {
            config.TAG_ADDITION = "";
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            config.setStackTraceElements(stackTraceElements);

            if (stackTraceElements.length >= 5) {
                String filename = stackTraceElements[4].getFileName();
                if (filename == null) {
                    return false;
                }

                if (config.isWithDetailCaller) {
                    config.TAG_ADDITION = filename + "->" +
                            stackTraceElements[4].getMethodName() +
                            (config.isWithDetailLine ? " line:" + stackTraceElements[4].getLineNumber() + " -> " : " ");
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public static void i(String message) {
        if (init())
            if (config.isLogEnable())
                android.util.Log.i(config.getTAG() + " i", config.TAG_ADDITION + message);
    }

    public static void d(String message) {
        if (init())
            if (config.isLogEnable())
                android.util.Log.d(config.getTAG() + " d", config.TAG_ADDITION + message);
    }

    public static void e(String message) {
        if (init())
            if (config.isLogEnable())
                android.util.Log.e(config.getTAG() + " e", config.TAG_ADDITION + message);
    }

    public static LogConfig buildConfig() {
        if (config == null) {
            config = new LogConfig();
        }
        return config;
    }


    public static void clearConfig() {
        config = null;
    }
}
