package farmkeeperfly.com.tiankuai.network.utils;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.util.concurrent.TimeUnit;

import farmkeeperfly.com.tiankuai.network.DiskCache;
import farmkeeperfly.com.tiankuai.network.NetWorkManager;
import farmkeeperfly.com.tiankuai.network.PingRequest;
import farmkeeperfly.com.tiankuai.network.request.BaseRequest;

/**网络请求工具类
 * Created by zhangguang on 2016/5/23.
 */
public class HttpUtils {
    private static  final OkHttpClient mClient = new OkHttpClient();
    static {
        mClient.setConnectTimeout(8, TimeUnit.SECONDS);
    }

    /**
     * get请求
     * @param callback
     */
    public static void get(BaseRequest<?> callback, String uid, String token)
    {
        if (NetWorkManager.CONNECTION_TYPE == -1)
        {
            LogUtil.i("未连接网络");
            callback.onFailure(null, new BaseRequest.NoActiveNetworkException(
                    "没有网络连接"));
            return;
        }
        if(uid == null || token == null){
            mClient.newCall(
                    new Request.Builder().url(callback.url).tag(callback.tag)
                            .build()).enqueue(callback);
        }else {
            mClient.newCall(
                    new Request.Builder().url(callback.url).tag(callback.tag)
                            //.header(GlobalConstant.UID, uid)
                          //  .header(GlobalConstant.TOKEN, token)
                            .build()).enqueue(callback);
        }
    }
    /**
     * Post请求
     * @param callback
     * @param uid
     * @param token
     * @param requestBody
     */
    public static void post(BaseRequest<?> callback,String uid,String token, RequestBody requestBody)
    {
        LogUtil.i(callback.url);
        if (NetWorkManager.CONNECTION_TYPE == -1)
        {
            LogUtil.i("未连接网络");
            callback.onFailure(null, new BaseRequest.NoActiveNetworkException(
                    "没有网络连接"));
            return;
        }
        if(uid == null || token == null){
            mClient.newCall(
                    new Request.Builder().url(callback.url).tag(callback.tag)
                            .post(requestBody).build()).enqueue(callback);
        }else {
            mClient.newCall(
                    new Request.Builder().url(callback.url).tag(callback.tag)
                           // .header(GlobalConstant.UID, uid)
                           // .header(GlobalConstant.TOKEN, token)
                            .post(requestBody).build()).enqueue(callback);
        }
    }

    public static void getFirstByCache(BaseRequest<?> callback,String uid,String token)
    {
        DiskCache.Entry entry = NetWorkManager.getInstance().diskCache
                .get(callback.url);
        if (entry != null)
        {
            callback.onCacheResponse(entry.data);
        }
        get(callback,uid,token);
    }



    public static void getFirstByCache(BaseRequest<?> callback,String uid,String token,RequestBody mRequestBody)
    {
        DiskCache.Entry entry = NetWorkManager.getInstance().diskCache
                .get(callback.url);
        if (entry != null)
        {
            callback.onCacheResponse(entry.data);
        }
        post(callback, uid, token, mRequestBody);
    }

    /**
     * 用head方式测试外网是否联通
     */
    public static void head(PingRequest callback)
    {
        if (NetWorkManager.CONNECTION_TYPE == -1)
        {
            LogUtil.i("未连接网络");
            callback.onFailure(null, new BaseRequest.NoActiveNetworkException(
                    "没有网络连接"));
            return;
        }
        mClient.newCall(
                new Request.Builder().url(PingRequest.URL).tag(PingRequest.TAG)
                        .head().build()).enqueue(callback);
    }

    public static void getOnlyByCache(BaseRequest<?> callback)
    {
        DiskCache.Entry entry = NetWorkManager.getInstance().diskCache
                .get(callback.url);
        if (entry != null)
        {
            callback.onCacheResponse(entry.data);
        }
        else
        {
            callback.onCacheFailure();
        }
    }

    /**
     * 取消相应tag的访问
     */
    public static void cancelRequest(Object tag)
    {
        mClient.cancel(tag);
    }
}
