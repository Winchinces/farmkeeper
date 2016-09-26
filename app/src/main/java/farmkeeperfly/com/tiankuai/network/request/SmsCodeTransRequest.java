package farmkeeperfly.com.tiankuai.network.request;

/**
 * Created by zhangguang on 2016/7/25.
 */
public class SmsCodeTransRequest extends BaseTransRequest {
    public SmsCodeTransRequest(String url, Object tag, Listener listener, boolean isCacheResult, Class from, Class to) {
        super(url, tag, listener, isCacheResult, from, to);
    }
}
