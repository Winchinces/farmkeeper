package farmkeeperfly.com.tiankuai.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import farmkeeperfly.com.tiankuai.R;
import farmkeeperfly.com.tiankuai.app.MyApplication;

/**
 * 全局共用的常用方法类
 * Created by zhangguang on 2016/5/30.
 */
public class CustomTools {
    /**
     * 获取软件包名
     *
     * @return
     */
    public static String getPackageName() {
        return MyApplication.globalContext.getPackageName();
    }

    /**
     * 获取versionCode（ANDROID版本号）
     */
    public static int getVersionCode() {
        int versioncode = 0;
        try {
            PackageInfo pinfo = MyApplication.globalContext.getPackageManager().getPackageInfo(getPackageName(), 0);
            versioncode = pinfo.versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versioncode;
    }

    /**
     * 获取版本号
     *
     * @return
     */
    public static String getVersionName() {
        try {
            PackageInfo pinfo = MyApplication.globalContext.getPackageManager().getPackageInfo(getPackageName(), 0);
            return pinfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取版本信息(平台号+版本号+渠道号)
     *
     * @return
     */
    public static String getVersionInfo() {
        try {
            String versionName = getVersionName();
            if (!TextUtils.isEmpty(versionName)) {
//                return getString(R.string.platformNo) + "." + versionName + "." + getString(R.string.channelsNo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 返回当前时间，单位毫秒
     *
     * @return
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获得当前日期和时间 格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String current_time = sdf.format(date);
        return current_time;
    }

    /**
     * 安装APK
     */
 /*   public static void installApk(Activity activity, String path) {
        File file = new File(path);
        if (file.exists()) {
            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            activity.startActivity(intent);
        } else {
            //软件安装失败的提示信息
            CustomTools.showToast(activity.getString(R.string.install_failed), false);
        }
    }
*/
    /**
     * 添加桌面快捷方式
     *
     * @param activity 点击图标启动intent
     * @param icon     桌面icon
     */
    public static void addShortcut(Activity activity, int icon, Activity start) {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");

        // 快捷方式的名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, activity.getString(R.string.app_name));
        shortcut.putExtra("duplicate", false); // 不允许重复创建

        // 指定当前的Activity为快捷方式启动的对象: 如 com.everest.video.VideoPlayer
        // 注意: ComponentName的第二个参数必须加上点号(.)，否则快捷方式无法启动相应程序
        // ComponentName comp = new ComponentName(activity.getPackageName(),
        // "."+activity.getLocalClassName());

        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(activity, start.getClass())
                .setAction(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER));
        // shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);

        // 快捷方式的图标
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(activity, icon);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);

        activity.sendBroadcast(shortcut);
    }

    /**
     * 调用系统电话
     *
     * @param activity
     * @param phoneNum
     */
    public static void openSystemPhone(Context activity, String phoneNum) {
        try {
            Intent it = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
            activity.startActivity(it);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        try {
            String phoneVersion = android.os.Build.MODEL;
            if (null != phoneVersion) {
                return phoneVersion;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获得手机IMEI
     *
     * @return
     */
    public static String getIMEI() {
        try {
            TelephonyManager tm = (TelephonyManager) MyApplication.globalContext
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String imei = tm.getDeviceId();
            if (null != imei) {
                return imei;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获得手机IMSI
     *
     * @return
     */
    public static String getIMSI() {
        try {
            TelephonyManager tm = (TelephonyManager) MyApplication.globalContext
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String imsi = tm.getSubscriberId();
            if (null != imsi) {
                return imsi;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 全局统一吐司类
     */
    private static Toast mToast;

    /**
     * 小提示
     *
     * @param msg      提示内容
     * @param longTime 是否长时间提醒
     */
    public static void showToast(String msg, boolean longTime) {
        Context context = MyApplication.globalContext;
        if (msg != null && context != null) {
            int timer = Toast.LENGTH_SHORT;
            if (longTime) {
                timer = Toast.LENGTH_LONG;
            } else {
                timer = Toast.LENGTH_SHORT;
            }

            if (mToast == null) {
                mToast = Toast.makeText(context, msg, timer);
            } else {
                mToast.setText(msg);
                mToast.setDuration(timer);
            }
            mToast.show();
        }
    }
        /**
         * 小提示
         *
         * @param resId       提示内容Id
         * @param longTime   是否长时间提醒
         */

    public static void showToast(int resId, boolean longTime) {
        Context context = MyApplication.globalContext;
        String msg = context.getResources().getString(resId);
        if (msg != null && context != null) {
            int timer = Toast.LENGTH_SHORT;
            if (longTime) {
                timer = Toast.LENGTH_LONG;
            } else {
                timer = Toast.LENGTH_SHORT;
            }

            if (mToast == null) {
                mToast = Toast.makeText(context, msg, timer);
            } else {
                mToast.setText(msg);
                mToast.setDuration(timer);
            }
            mToast.show();
        }


    }

  /*  *//**
     * 获取最后一条短信
     *
     * @param context
     * @return
     *//*
    public static SMSBean getLastSms(Context context) {
        Cursor csr = null;
        SMSBean smsBean = null;
        try {
            csr = context.getContentResolver().query(Uri.parse("content://sms"),
                    new String[]{"date", "address", "body", "type"}, "type = 1", null, " date DESC LIMIT 1");
            csr.moveToFirst();
            smsBean = new SMSBean();
            smsBean.setAddress(csr.getString(1));
            smsBean.setMsg_snippet(csr.getString(2));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (csr != null) {
                csr.close();
            }
        }
        return smsBean;
    }*/
    private static String oldMsg;
    protected static Toast toast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;

    public static void showToast(Context context, String s) {
        if (toast == null) {
            toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (s.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        oneTime = twoTime;
    }

    /**
     * 获得手机的uuid
     * @param context
     * @return
     */
    public static String commitUniqueID(Context context){
        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString();
    }

}
