package farmkeeperfly.com.tiankuai.network.request;

/**
 * Created by NTGJ on 2016/8/8.
 */
public class AddBitCustomers extends BaseTransRequest{
    public AddBitCustomers(String url, Object tag, Listener listener, boolean isCacheResult, Class from, Class to) {
        super(url, tag, listener, isCacheResult, from, to);
    }
}
