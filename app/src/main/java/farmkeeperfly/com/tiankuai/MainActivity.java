package farmkeeperfly.com.tiankuai;

import android.os.Bundle;

import farmkeeperfly.com.tiankuai.base.BaseActivity;
import farmkeeperfly.com.tiankuai.fragment.CompletePlotDataFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.fragment_container);
        CompletePlotDataFragment fragment=new CompletePlotDataFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setContentView() {

    }
}
