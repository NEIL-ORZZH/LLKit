package com.lollypo.mobilesafe.util;

/**
 * Created by Lollypo on 15/2/14.
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 流相关工具类
 */
public class LLStream {

    /**
     * 从输入流中读取字符串
     * @param is
     * @return
     */
    public static String read(InputStream is){
        String result = "";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            while ((len=is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            result = baos.toString();
        } catch (IOException e) {
            LLLog.e(e.getMessage());
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    LLLog.e(e.getMessage());
                }
            }
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    LLLog.e(e.getMessage());
                }
            }
        }
        return result;
    }
}
