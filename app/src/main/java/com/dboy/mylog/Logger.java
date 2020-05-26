package com.dboy.mylog;

import android.util.Log;

public class Logger extends BaseLog {

    private static String TAG = "Logger";

    private static boolean DEBUG = BuildConfig.DEBUG;

    public static void setDefTAG(String tag) {
        TAG = tag;
    }

    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }

    public static void d(Object... msg) {
        if (DEBUG) {
            Log.d(getAutoJumpLogInfos(TAG), toString(msg));
        }
    }

    public static void e(Object... msg) {
        if (DEBUG) {
            Log.e(getAutoJumpLogInfos(TAG), toString(msg));
        }
    }

    /**
     * 将参数一行行打印
     */
    public static void dd(Object... msg) {
        if (DEBUG) {
            printParameter(getAutoJumpLogInfos(TAG), 1, msg);
        }
    }


}




