package com.example.talk;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.Log;

public class LLBitmap {
	
	private static final String TAG = "LLBitmap";
	
	/**
	 * 
	 * @param res
	 * @param resId
	 */
	public static void loadOptions(Resources res,int resId){
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;	// 设置为true会返回null而不是Bitmap
		BitmapFactory.decodeResource(res, resId,options);
		// 读取属性
		int resWidth = options.outWidth;
		int resHeight = options.outHeight;
		String imageType = options.outMimeType;
		// 读取结束后要切换回来
		options.inJustDecodeBounds = false;
		
		Log.e(TAG, "resWidth="+resWidth);
		Log.e(TAG, "resHeight="+resHeight);
		Log.e(TAG, "imageType="+imageType);
	}
}
