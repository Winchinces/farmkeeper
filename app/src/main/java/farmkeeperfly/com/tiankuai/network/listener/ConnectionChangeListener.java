package farmkeeperfly.com.tiankuai.network.listener;

/**
 * 网络状态回调接口
 * Created by zhangguang on 2016/5/19.
 */
public interface ConnectionChangeListener {
    void onConnectionChanged(int type);
}
