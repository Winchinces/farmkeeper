package farmkeeperfly.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private ToggleButton mToggleButton;
    private TextView tvSound;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_main);
        initView();//初始化控件方法
    }

    private void initView() {
        mToggleButton = (ToggleButton) findViewById(R.id.tglSound); //获取到控件
        mToggleButton.setOnCheckedChangeListener(this);//添加监听事件
        tvSound = (TextView) findViewById(R.id.tvSound);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            tvSound.setText("已开启");
        }else{
            tvSound.setText("已关闭");
        }
    }
}
