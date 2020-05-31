package com.dboy.mylog;

import android.util.Log;

public class Logger extends BaseLog {

    private static String TAG = "Logger";

    private static boolean DEBUG = BuildConfig.DEBUG;

    /**
     * 设置默认TAG
     *
     * @param tag TAG
     */
    public static void setDefTag(String tag) {
        TAG = tag;
    }

    /**
     * 设置日志打印类型
     *
     * @param debug
     */
    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }

    /**
     * d log
     */
    public static void d(Object... msg) {
        if (DEBUG) {
            Log.d(logClassLine(TAG), logToString(msg));
        }
    }

    /**
     * e log
     */
    public static void e(Object... msg) {
        if (DEBUG) {
            Log.e(logClassLine(TAG), logToString(msg));
        }
    }

    /**
     * e log
     */
    public static void e(Throwable throwable, Object... msg) {
        if (DEBUG) {
            Log.e(logClassLine(TAG), logToString(msg) + "\n", throwable);
        }
    }

    /**
     * 将参数一行行打印
     */
    public static void dd(Object... msg) {
        if (DEBUG) {
            lineLinePrint(logClassLine(TAG),msg);
        }
    }


}




