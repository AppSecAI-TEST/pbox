package com.ipricebox.android.common.util;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ipricebox.android.R;

public class ToastUtils {

	private static long sLastShowTime = -1;

	private static void showToast(final Context context, final int textid, final String text,
								  final int delay, final boolean allowToastQueue) {
		long currentTime = System.currentTimeMillis();
		if (!allowToastQueue && currentTime - sLastShowTime < 3000)
			return;
		else {
			sLastShowTime = currentTime;
		}
		if (context == null)
			return;
		new Handler(context.getMainLooper()).post(new Runnable() {

			@Override
			public void run() {
				if (textid == -1) {
					Toast.makeText(context, text, delay).show();
				} else {
					Toast.makeText(context, textid, delay).show();
				}
			}
		});
	}

	public static void showShortToast(final Context context, final int textid) {
		showToast(context, textid, null, Toast.LENGTH_SHORT, false);
	}

	public static void showShortToast(final Context context, final String text) {
		showToast(context, -1, text, Toast.LENGTH_SHORT, false);
	}

	public static void showLongToast(final Context context, final int textid) {
		showToast(context, textid, null, Toast.LENGTH_LONG, false);

	}

	public static void showLongToast(final Context context, final String text) {
		showToast(context, -1, text, Toast.LENGTH_LONG, false);
	}

	/**
	 * 
	 * @param context
	 * @param textid
	 * @param allowToastQueue
	 *            是否允许Toast等待显示, 如果不允许, 3秒内的第二条Toast将不被显示
	 */
	public static void showShortToast(final Context context, final int textid,
									  boolean allowToastQueue) {
		showToast(context, textid, null, Toast.LENGTH_SHORT, allowToastQueue);
	}

	/**
	 * 
	 * @param context
	 * @param text
	 * @param allowToastQueue
	 *            是否允许Toast等待显示, 如果不允许, 3秒内的第二条Toast将不被显示
	 */
	public static void showShortToast(final Context context, final String text,
									  boolean allowToastQueue) {
		showToast(context, -1, text, Toast.LENGTH_SHORT, allowToastQueue);
	}

	/**
	 * 
	 * @param context
	 * @param textid
	 * @param allowToastQueue
	 *            是否允许Toast等待显示, 如果不允许, 3秒内的第二条Toast将不被显示
	 */
	public static void showLongToast(final Context context, final int textid,
									 boolean allowToastQueue) {
		showToast(context, textid, null, Toast.LENGTH_LONG, allowToastQueue);

	}

	/**
	 * 
	 * @param context
	 * @param text
	 * @param allowToastQueue
	 *            是否允许Toast等待显示, 如果不允许, 3秒内的第二条Toast将不被显示
	 */
	public static void showLongToast(final Context context, final String text,
									 boolean allowToastQueue) {
		showToast(context, -1, text, Toast.LENGTH_LONG, allowToastQueue);
	}

	public static void showCustomToast(final Context context,final String text) {
		new Handler(context.getMainLooper()).post(new Runnable() {

			@Override
			public void run() {
				Toast toast = new Toast(context);
				final View view = LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, null);
				TextView tips = (TextView) view.findViewById(R.id.tv_custom_text);
				tips.setText(text);
				toast.setView(view);
				toast.setGravity(Gravity.CENTER,0,0);
				toast.show();
			}
		});
	}
}
