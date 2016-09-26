package farmkeeperfly.com.tiankuai.network.utils;


import farmkeeperfly.com.tiankuai.BuildConfig;

/**
 * Created by zhang on 2015/5/23.
 */
public class LogUtil
{
	private static final String TAG = "LogUtil";

	public static void v(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			android.util.Log.v(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			android.util.Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			android.util.Log.i(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			android.util.Log.w(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (BuildConfig.DEBUG) {
			android.util.Log.e(tag, msg);
		}
	}

	public static void e(String tag, String msg, Throwable t) {
		if (BuildConfig.DEBUG) {
			android.util.Log.e(tag, msg, t);
		}
	}

	@Deprecated
	public static void i(String msg) {
		LogUtil.i(TAG, msg);
	}

	@Deprecated
	public static void d(String msg) {
		LogUtil.d(TAG, msg);
	}

	@Deprecated
	public static void e(String msg) {
		LogUtil.e(TAG, msg);
	}
}
