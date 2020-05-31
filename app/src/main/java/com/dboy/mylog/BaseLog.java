package com.dboy.mylog;

import android.util.Log;

import java.util.Locale;

public class BaseLog {


    protected static String logToString(Object... msg) {
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
            String s = sb.toString();
            if (s.isEmpty()) {
                return logMethodLine();
            }
            return s;
        } catch (Exception e) {
            return logMethodLine();
        }
    }

    /**
     * 逐行打印
     */
    protected static void lineLinePrint(String tag, Object... msg) {
        lineLinePrint(logClassLine(tag), 1, msg);
    }

    /**
     * 逐行打印
     */
    private static void lineLinePrint(String logPos, int nextParameter, Object... msg) {
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
            lineLinePrint(logPos, nextParameter, msg);
        }
    }

    protected static String logMethodLine() {
        try {
            // 占位符模板
            String template = "Method:(%s)";
            String index = " ";
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            if (elements.length < 5) {
                return index;
            } else {
                String methodName = elements[5].getMethodName();
                index += String.format(Locale.ENGLISH, template, methodName);
                return index;
            }
        } catch (Exception e) {
            return " ";
        }
    }

    /**
     * 获取打印信息所在方法名，行号等信息
     */
    protected static String logClassLine(String tag) {
        try {
            // 占位符模板
            String template = "(%s:%d)";
            String index = tag;
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            if (elements.length < 5) {
                return index;
            } else {
                String className = elements[4].getFileName();
                int lineNumber = elements[4].getLineNumber();
                index += String.format(Locale.ENGLISH, template, className, lineNumber);

                if (index.isEmpty()) {
                    index += "(" + className + ":"
                            + lineNumber + ")";
                }
                return index;
            }
        } catch (Exception e) {
            return tag;
        }
    }

}
