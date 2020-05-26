package com.dboy.mylog;

import android.util.Log;

public class BaseLog {


    protected static String toString(Object... msg) {
        try {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < msg.length; i++) {
                if (i == 0) {
                    sb.append("[" + msg[i] + "]\t");
                    continue;
                }
                sb.append(msg[i]);
                sb.append("\t");
            }
            return sb.toString();
        } catch (Exception e) {
            return "Log 参数 异常";
        }
    }

    protected static void printParameter(String logPos, int nextParameter, Object... msg) {
        if (msg.length == 0) {
            Log.d(logPos, "");
            return;
        }

        String tag = "[" + msg[0].toString() + "]";

        String paramenter = "";

        if (msg.length >= 2) {
            paramenter = msg[nextParameter].toString();
        }
        Log.d(logPos, tag + "\t" + paramenter);

        ++nextParameter;
        if (nextParameter < msg.length) {
            printParameter(logPos, nextParameter, msg);
        }
    }

    /**
     * 获取打印信息所在方法名，行号等信息
     */
    protected static String getAutoJumpLogInfos(String TAG) {
        try {
            String tag = "(%s:%d)"; // 占位符
            String index = TAG;
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            if (elements.length < 5) {
                return index;
            } else {
                String className = elements[4].getFileName();
                String methodName = elements[4].getMethodName();
                int lineNumber = elements[4].getLineNumber();
                index   += String.format(tag, className, lineNumber);

                if (index.isEmpty()) {
                    index += "(" + className + ":"
                            + lineNumber + ")";
                }
                return index;
            }
        } catch (Exception e) {
            return TAG;
        }
    }

}
