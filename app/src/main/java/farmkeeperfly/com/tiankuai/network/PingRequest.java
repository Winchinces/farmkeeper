package farmkeeperfly.com.tiankuai.network;


import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import farmkeeperfly.com.tiankuai.network.utils.HttpUtils;


/**
 * Created by zhang on 2015/5/23. 测试网络联通状况的请求
 */
public class PingRequest implements Callback
{
	public static final String TAG = "Ping";
	public static final String URL = "http://www.baidu.com";
	private PingListener mListener;

	public PingRequest(PingListener listener)
	{
		this.mListener = listener;
	}

	/**
	 * 执行ping操作
	 */
	public static void performPing(PingListener listener)
	{
		HttpUtils.head(new PingRequest(listener));
	}

	public static void cancelPing()
	{
		HttpUtils.cancelRequest(TAG);
	}

	@Override
	public void onFailure(Request request, IOException e)
	{
		NetWorkManager.getInstance().UIHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				mListener.onPingFinished(false);
			}
		});
	}

	@Override
	public void onResponse(Response response) throws IOException
	{
		NetWorkManager.getInstance().UIHandler.post(new Runnable()
		{
			@Override
			public void run()
			{
				mListener.onPingFinished(true);
			}
		});
	}

	public interface PingListener
	{
		void onPingFinished(boolean isOK);
	}
}
