package com.lollypo.mobilesafe.util;

import android.util.Log;

/**
 * Created by Lollypo on 15/2/12.
 */

/**
 * 日志相关工具类
 */
public class LLLog {
    
    // 默认的TAG
    private static String  TAG     = "LLLog";
    // Log是否打印
    private static boolean LOGABLE = true;

    /**
     * 设置TAG
     * @param tag
     */
    public static void setTAG(String tag){
        TAG = tag;
    }

    public static void toogleLog(boolean isOn){
        LOGABLE = isOn;
    }

    // VERBOSE
    public static void v(String msg){
        if (LOGABLE){
            Log.v(TAG,msg);
        }
    }
    // DEBUG
    public static void d(String msg){
        if (LOGABLE){
            Log.d(TAG,msg);
        }
    }
    // INFO
    public static void i(String msg){
        if (LOGABLE){
            Log.i(TAG,msg);
        }
    }
    // WARN
    public static void w(String msg){
        if (LOGABLE){
            Log.w(TAG,msg);
        }
    }
    // ERROR
    public static void e(String msg){
        if (LOGABLE){
            Log.e(TAG,msg);
        }
    }
}
