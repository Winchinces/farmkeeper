package farmkeeperfly.com.tiankuai.network.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

/**
 * Created by zhangguang on 2015/5/19
 */
public class NetWorkUtils {

    /**
     * 没有网络，打开系统的设置页面
     * @param context
     */
    public static void goSystemSetting(Context context){
        if(android.os.Build.VERSION.SDK_INT > 10 ){
            //3.0以上打开设置界面，也可以直接用ACTION_WIRELESS_SETTINGS打开到wifi界面
            context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
        } else {
            context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        }
    }

    /**
     * 返回网络类型 -1 没有网络   1 无线网络    0 手机网络4G
     */
    public static int getActiveNetwork(Context context)
    {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null)
        {
            return info.getType();
        }
        return -1;
    }

    /**
     * 如果网络类型是WIFI，返回WIFI信号强度
     */
    public static int getWifiLevel(Context context)
    {
        return WifiManager.calculateSignalLevel(((WifiManager) context
               .getSystemService(Context.WIFI_SERVICE)).getConnectionInfo()
                .getRssi(), 4);
    }

    /**
     * 判断当前是否有网络
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            //  Log.i("NetWorkState", "Unavailabel");
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        // Log.i("NetWorkState", "Availabel");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

