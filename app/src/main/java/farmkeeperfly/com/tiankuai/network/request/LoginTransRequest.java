package farmkeeperfly.com.tiankuai.network.request;

/**
 * Created by zhangguang on 2016/7/25.
 */
public class LoginTransRequest extends BaseTransRequest {
    public LoginTransRequest(String url, Object tag, Listener listener, boolean isCacheResult, Class from, Class to) {
        super(url, tag, listener, isCacheResult, from, to);
    }
}
