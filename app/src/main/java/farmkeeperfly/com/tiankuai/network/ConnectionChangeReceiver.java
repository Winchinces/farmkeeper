package farmkeeperfly.com.tiankuai.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import farmkeeperfly.com.tiankuai.network.listener.ConnectionChangeListener;


/**网络状态广播
 * Created by zhangguang 2016/5/19.
 */
public class ConnectionChangeReceiver extends BroadcastReceiver
{
	private static ArrayList<ConnectionChangeListener> mList = new ArrayList<ConnectionChangeListener>();

	/**
	 * 一般在activity，onstart方法调用注册
	 */
	public static void registerConnectionListener(
	        Context context,ConnectionChangeListener listener)
	{
		mList.add(listener);
		// 每次注册，先返回一下
		//GlobalConstant.CONNECTION_TYPE =  NetWorkUtils.getActiveNetwork(context);
	//	listener.onConnectionChanged(GlobalConstant.CONNECTION_TYPE);
	}

	/**
	 * 一般在activity，onstop方法解除注册
	 */
	public static void unregisterConnectionListenr(
	        ConnectionChangeListener listener)
	{
		mList.remove(listener);
	}

	@Override
	public void onReceive(Context context, Intent intent)
	{
		//GlobalConstant.CONNECTION_TYPE = NetWorkUtils.getActiveNetwork(context);
		for (ConnectionChangeListener listener : mList)
		{
			//listener.onConnectionChanged(GlobalConstant.CONNECTION_TYPE);
		}
	}

}
