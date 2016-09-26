package farmkeeperfly.com.tiankuai.app;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 项目名称：MyApplication
 * 类描述：
 * 创建人：wen
 * 创建时间：2016/9/23 20:02
 * 修改备注：
 */
public class MyApplication extends Application {
 public static Context globalContext;
    @Override
    public void onCreate() {
        super.onCreate();
        globalContext=this;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }
}
