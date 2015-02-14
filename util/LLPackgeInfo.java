package com.lollypo.mobilesafe.util;

/**
 * Created by Lollypo on 15/2/14.
 */

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 版本相关工具类
 */
public class LLPackgeInfo {

    /**
     * 获取Apk包信息
     * @param context
     * @param packgeName
     * @return
     */
    public static PackageInfo getPackgeInfo(Context context,String packgeName){
        PackageInfo info = null;
        try {
            info = context.getPackageManager().getPackageInfo(packgeName,0);
        } catch (PackageManager.NameNotFoundException e) {
            LLLog.e(e.getMessage());
        }
        return info;
    }

    /**
     * 获取版本名称
     * @param context
     * @param packgeName
     * @return
     */
    public static String getVersionName(Context context,String packgeName){
        return getPackgeInfo(context,packgeName).versionName;
    }
}
