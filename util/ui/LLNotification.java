package com.learn2crack.notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;

/**
 * Notification工具类
 * 		仅支持4.0以上
 */
public class LLNotification {

	/**
	 * 发送一个带图片的普通Notification
	 * 
	 * @param context
	 *            上下文
	 * @param nextContext
	 *            点击Notification跳转到的Activity
	 * @param msgId
	 *            Notification的Id
	 * @param msgTitle
	 *            Notification的标题
	 * @param msgContent
	 *            Notification的内容
	 * @param alertMsg
	 *            接收Notification时的提示信息
	 * @param msgIcon
	 *            Notification的小图标
	 */
	@SuppressLint("NewApi")
	public static void showSmallNotification(Context context,
			Class nextContext, int msgId, String msgTitle, String msgContent,
			String msgTicker, int msgIcon) {

		// 创建 Notification Builder
		Notification.Builder builder = new Notification.Builder(context)
				.setContentTitle(msgTitle) // Notification的标题
				.setContentText(msgContent) // Notification的内容
				.setTicker(msgTicker) // 接收到Notification时的信息
				.setSmallIcon(msgIcon) // Notification的图标
				.setAutoCancel(true) // True时点击会关闭Notification
				.setContentIntent(//
						TaskStackBuilder
								// 创建Stack Builder
								.create(context)
								.addParentStack(nextContext)
								// 当Notification被点击时跳转
								.addNextIntent(new Intent(context, nextContext))
								// 更新当前的Notification)
								.getPendingIntent(msgId,
										PendingIntent.FLAG_UPDATE_CURRENT));

		final NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		manager.notify(msgId, builder.build());
	}
}
