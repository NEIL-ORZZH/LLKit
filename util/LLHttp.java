package com.lollypo.mobilesafe.util;

/**
 * Created by Lollypo on 15/2/14.
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Http相关工具类
 */
public class LLHttp {
    /**
     * 发送请求,将得到的数据转换成字符串
     * @param urls
     * @param timeout
     */
    public static String request(String urls,int timeout){
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urls);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(timeout);

            int responseCode = connection.getResponseCode();
            // 请求成功
            if (responseCode == 200){
                InputStream in = connection.getInputStream();
                // TODO 需要得到不同的返回类型只需要修改这句即可
                return LLStream.read(in);
            }
        } catch (MalformedURLException e) {
            LLLog.e(e.getMessage());
        } catch (IOException e) {
            LLLog.e(e.getMessage());
        }
        return "";
    }
}
