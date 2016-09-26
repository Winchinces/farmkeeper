package farmkeeperfly.com.tiankuai.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import farmkeeperfly.com.tiankuai.R;
import farmkeeperfly.com.tiankuai.base.BaseFragment;

/**
 * Created by NTGJ on 2016/9/23.
 */

public class MyFragment extends BaseFragment {
    private ImageView myheadphoto;
    private TextView myname;
    private TextView mycompanyInfo;
    private TextView my_exit;

    @Override
    protected int getContentView() {
        return R.layout.fragment_my;


    }

    @Override
    protected void findView(View view) {
        this.mycompanyInfo = (TextView) view.findViewById(R.id.my_companyInfo);
        this.myname = (TextView) view.findViewById(R.id.my_name);
        this.myheadphoto = (ImageView) view.findViewById(R.id.my_headphoto);
        this.my_exit = (TextView) view.findViewById(R.id.my_exit);
    }

    @Override
    protected void initView() {
        changerTitle(R.string.my);//改变标题
        hideRight();//隐藏左标题
        my_exit.setOnClickListener(this);
        iniData();
    }

    //网络请求，空间赋值
    private void iniData() {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.my_exit:
                //退出逻辑
                break;
        }

    }
}
