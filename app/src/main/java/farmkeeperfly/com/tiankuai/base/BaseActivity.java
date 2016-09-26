package farmkeeperfly.com.tiankuai.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import farmkeeperfly.com.tiankuai.network.utils.LogUtil;


/**
 * Created by zhangguang on 2016/5/6.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    private static final String TAG = "BaseActivity";
    private View mLoadingView;
 //   private CustomProgressdialog mLoading;
  //  private MyApplication mApplication;
    private String accountId;
    private Handler mHandler = new Handler(){};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.v(getClass().getSimpleName(), "onCreate");
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN|WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

      //  mApplication = (MyApplication) getApplication();
      //  mApplication.addActivity(this);


     //   Preferences preferences = Preferences.build(this);
    //    accountId = preferences.getString("accountId", "");

        // MobclickAgent.setDebugMode(false);
        // MobclickAgent.openActivityDurationTrack(false);
        // MobclickAgent.setScenarioType(this, // MobclickAgent.EScenarioType.E_UM_NORMAL);
        // MobclickAgent.onProfileSignIn(accountId);


        setContentView();
//        findView();
        initView();


    }

    @Override
    protected void onDestroy() {
        LogUtil.v(getClass().getSimpleName(), "onDestroy");
        super.onDestroy();
       // mApplication.removeActivity(this);
        Log.i(TAG, "BaseDestroy:" + this);
       // mApplication = null;
        System.gc();
    }

//    protected abstract void findView();
    protected abstract void initView();
    protected abstract void setContentView();
    public void gotoActivity(Class<?extends Activity> cls,Bundle bundle){
        Intent intent = new Intent(this,cls);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    public void gotoActivity(Class<? extends Activity> cls) {
        gotoActivity(cls, null);
    }
    public void gotoActivityForResult(Class<?extends Activity> toCls,int requestCode){
        Intent intent = new Intent(this,toCls);
        startActivityForResult(intent, requestCode);
    }

    public void showLoading(String message) {
     //   if (null == mLoading) {
           // mLoading = new CustomProgressdialog(this, message, true, true);
     //   }
    }

    public void hindLoading(){
        Log.i(TAG, "unMLoading");
      //  if(mLoading != null && mLoading.isShowing()) {
          //  mLoading.dismiss();
         //   mLoading = null;
      //  }
    }

    @Override
    public void onResume() {
        LogUtil.v(getClass().getSimpleName(), "onResume");
        // MobclickAgent.onPageStart(TAG);
        // MobclickAgent.onResume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        LogUtil.v(getClass().getSimpleName(), "onPause");
        // MobclickAgent.onPageEnd(TAG);
        // MobclickAgent.onPause(this);
        super.onPause();
    }


    public void showBack(){
      //  View titleLeftImage = view.findViewById(R.id.titleLeftImage);
      //  if(!titleLeftImage.isShown()){
      //      titleLeftImage.setVisibility(View.VISIBLE);
      //      titleLeftImage.setOnClickListener(this);
     //   }

    }

    public void hideTabs() {

          //  view.findViewById(R.id.rg_tabs).setVisibility(View.GONE);
           // view.findViewById(titleLeftImage).setVisibility(View.VISIBLE);


    }

    public void showTabs() {

       //  view.findViewById(R.id.rg_tabs).setVisibility(View.VISIBLE);
        //    view.findViewById(titleLeftImage).setVisibility(View.GONE);

    }

    public void changerTitle(int resId){

            String title= getResources().getString(resId);
            changerTitle(title);

    }

    public void changerTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
         //   TextView title_tv = (TextView)view.findViewById(R.id.sale_title);
          //  title_tv.setText(title);
        }
    }

    public void changerTitle() {

           // TextView title_tv = (TextView)view.findViewById(R.id.sale_title);
           // title_tv.setText(R.string.app_name);

    }

    public void showRight(int resId){

            String title=getResources().getString(resId);
            showRight(title);

    }

    //显示导航条右边菜单
    public void showRight(String... title) {
           // TextView sale_add = (TextView)view.findViewById(R.id.sale_add);
         /*   if (!sale_add.isShown()) {
                sale_add.setVisibility(View.VISIBLE);
            }
            if (title != null) {
                sale_add.setText(title[0]);
            }
            sale_add.setOnClickListener(this);*/
        }

    //隐藏导航条右边菜单
    public void hideRight(){
       /* TextView sale_add = (TextView)view.findViewById(sale_add);
        sale_add.setVisibility(View.GONE);*/
        }

    @Override
    public void onClick(View view) {

    }
}
