package com.example.alex.collectionsandmap.utils;

import android.util.Log;
import com.example.alex.collectionsandmap.BuildConfig;

import io.michaelrocks.paranoid.Obfuscate;


//@Obfuscate
public class Logger {

    private String logTag;

    private boolean isLogging = BuildConfig.SHOW_LOGS;

    public Logger(Class c) {
        logTag = c.getSimpleName();
    }

    public void log(String message) {
        if (isLogging)
            Log.d(logTag, message);
    }

    public void error(Throwable message) {
        if (isLogging)
            Log.e(logTag, message.toString());
    }
}
