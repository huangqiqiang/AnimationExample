/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hqq.viewexample.Utils;


import android.util.Log;

/**
 * @author: huangqiqiang
 * 在此写用途
 * @FileName:
 *          ${PACKAGE_NAME}.${NAME}.java
 * @emain: 593979591@qq.com
 * @date: ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
 * @version V1.0 <描述当前版本功能>
 */
public class LogUtils {
	/**
	 * Log的开关<br>
	 * true为开启<br>
	 * false为关闭<br>
	 */
	public static boolean DEBUG = true;

	/**
	 * Log 输出标签
	 */
	public static String TAG = "LogUtils";

	public static void i(Object object) {
		if (DEBUG) {
			if (object == null) {
				i("标签" + TAG + "的打印内容为空！");
			}
			Log.i(TAG, object.toString());
		}
	}

	public static void d(Object object) {
		if (DEBUG) {
			if (object == null) {
				d("标签" + TAG + "的打印内容为空！");
			}
			Log.d(TAG, object.toString());
		}
	}

	public static void e(Object object) {
		if (DEBUG) {
			if (object == null) {
				e("标签" + TAG + "的打印内容为空！");
			}
			Log.e(TAG, object.toString());
		}
	}
	public static void e(String object) {
		if (DEBUG) {
			if (object == null) {
				e("标签" + TAG + "的打印内容为空！");
			}
			Log.e(TAG, object.toString());
		}
	}

	public static void v(Object object) {
		if (DEBUG) {
			if (object == null) {
				v("标签" + TAG + "的打印内容为空！");
			}
			Log.v(TAG, object.toString());
		}
	}

	public static void w(Object object) {
		if (DEBUG) {
			if (object == null) {
				w("标签" + TAG + "的打印内容为空！");
			}
			Log.w(TAG, object.toString());
		}
	}
	public static void inner_i(Object object, boolean DEBUG){
		if(DEBUG){
			i(object);
		}
	}
	public static void inner_e(Object object, boolean isShow){
		if(isShow){
			e(object);
		}
	}
	public static void inner_d(Object object, boolean DEBUG){
		if(DEBUG){
			d(object);
		}
	}
}
