package com.example.talk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class LLBitmap {

	@SuppressWarnings("unused")
	private static final String TAG = "LLBitmap";

	// **计算图片需要缩小的比例**//
	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// The Origins inSampleSize is 1 , no scale
		int inSampleSize = 1;
		// The Image's Width&Height
		final int width = options.outWidth;
		final int height = options.outHeight;
		// While The Width&&Height greatter than the required dimessions
		if (height > reqHeight || width > reqWidth) {
			// The two value divided 2
			// because inSampleSize will be multiplied 2 in the while statement
			final int halfHeight = height / 2;
			final int halfWidth = width / 2;
			// While the halfValue divided inSampleSize greater than reqValue
			// Make the inSampleSize Double
			while ((halfWidth / inSampleSize) > reqWidth
					&& (halfHeight / inSampleSize) > reqHeight) {
				inSampleSize *= 2;
			}
		}
		return inSampleSize;
	}

	// **从Resources中获取Bitmap**//
	public static Bitmap loadBitmapFromResource(Resources res,
			int resId, int reqWidth, int reqHeight) {

		// First set the inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);
		// Caculate the inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
		// Close the inJustDecodeBounds
		options.inJustDecodeBounds = false;

		return BitmapFactory.decodeResource(res, resId, options);
	}
}
