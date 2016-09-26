package farmkeeperfly.com.tiankuai.network.request;


import com.google.gson.Gson;

import farmkeeperfly.com.tiankuai.network.utils.TransformUtil;

/**
 * Created by zhangguang on 2015/5/23. 模型类转换的基类，做一些通用操作<E,T> E 原始数据类型 T 结果数据类型
 */
public class BaseTransRequest<F, T> extends BaseRequest {
    /**
     * 原始数据类型
     */
    private Class<F> mClsFrom;
    /**
     * 结果数据类型
     */
    private Class<T> mClsTo;

    public BaseTransRequest(String url, Object tag, Listener listener,
                            boolean isCacheResult, Class<F> from, Class<T> to) {
        super(url, tag, listener, isCacheResult);
        mClsFrom = from;
        mClsTo = to;
    }

    protected Object getTransStruct(F f) throws CloneNotSupportedException {
        return f;
    }
    /**
    * 实现抽象方法，执行转换操
     * * */
    @Override
    protected Object parseNetWorkResponse(byte[] data) {
        try {
            Gson gson = new Gson();
            String json = new String(data);
            F f = TransformUtil.getObjectFromJSON(json, mClsFrom);
            String temp = TransformUtil.setObjectToJSON(getTransStruct(f), gson);
            return TransformUtil.getObjectFromJSON(gson, temp, mClsTo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
