package farmkeeperfly.com.tiankuai.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.List;


/**
 * Created by zhangguang on 2016/5/12.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {


    protected static final String TAG = "BaseFragment";
    protected FrameLayout mContainer;
    private View mContentView;
 //   private CustomProgressdialog mLoading;

    /** Fragment当前状态是否可见 */
    protected boolean isVisible;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
        }
    }

    public  void onVisible(){
        lazyLoad();
    }

    private void lazyLoad() {

    }

    ;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
        initView();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContainer = getContainer();
        mContentView = inflater.inflate(getContentView(), container, false);
        mContainer.addView(mContentView);
        return mContainer;
    }


    @Override
    public void onResume() {
        super.onResume();
       // GlobalConstant.mCurrentFragment=this;
    }


    protected abstract int getContentView();

    protected abstract void findView(View view);

    protected abstract void initView();

    private FrameLayout getContainer() {
        return new FrameLayout(getActivity().getApplicationContext());
    }

    public void gotoActivity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void gotoActivity(Class<? extends Activity> cls) {
        gotoActivity(cls, null);
    }

    public void gotoActivityForResult(Class<? extends Activity> toCls, int requestCode) {
        Intent intent = new Intent(getActivity(), toCls);
        startActivityForResult(intent, requestCode);
    }

    public void gotoFragment(Fragment fragment, Bundle bundle) {
        if (getActivity() != null) {

        }

    }

    public void showLoading(String message) {
   /*    if(UpdateDialog.isContextValid(getActivity())){
           if(mLoading==null){
               mLoading = new CustomProgressdialog(getActivity(), message, true, true);
           }
           if(!mLoading.isShowing()){
               mLoading.show();
           }
       }*/

    }

    public void hindLoading() {
      /*  if (mLoading != null&& mLoading.isShowing()) {
            mLoading.dismiss();
            mLoading = null;
        }*/
    }

    public void hideTabs() {
        if (getActivity() != null) {
            //getActivity().findViewById(R.id.rg_tabs).setVisibility(View.GONE);
          //  getActivity().findViewById(R.id.titleLeftImage).setVisibility(View.VISIBLE);
           // getActivity().findViewById(R.id.titleLeftImage).setOnClickListener(this);
        }
    }

    public void showTabs() {
        if (getActivity() != null) {
         //   getActivity().findViewById(R.id.rg_tabs).setVisibility(View.VISIBLE);
           // getActivity().findViewById(R.id.titleLeftImage).setVisibility(View.GONE);

        }
    }

    public void changerTitle(int resId){
        if(getActivity()!=null){
            String title= getActivity().getResources().getString(resId);
            changerTitle(title);
        }
    }

    public void changerTitle(String title) {
        if (getActivity() != null && !TextUtils.isEmpty(title)) {
           // TextView title_tv = (TextView) getActivity().findViewById(R.id.sale_title);
           // title_tv.setText(title);
        }
    }

    public void changerTitle() {
        if (getActivity() != null) {
          //  TextView title_tv = (TextView) getActivity().findViewById(R.id.sale_title);
            //title_tv.setText(R.string.app_name);
        }
    }

    public void showRight(int resId){
        if(getActivity()!=null){
           String title=getActivity().getResources().getString(resId);
            showRight(title);
        }
    }

    //显示导航条右边菜单
    public void showRight(String... title) {
        if (getActivity() != null) {
           // TextView sale_add = (TextView) getActivity().findViewById(R.id.sale_add);
           /* if (!sale_add.isShown()) {
                sale_add.setVisibility(View.VISIBLE);
            }
            if (title != null) {
                sale_add.setText(title[0]);
            }
            sale_add.setOnClickListener(this);*/
        }
    }
    //隐藏导航条右边菜单
    public void hideRight(){
        if(getActivity()!=null){
         /*   TextView sale_add = (TextView) getActivity().findViewById(R.id.sale_add);
            if(sale_add.isShown()){
                sale_add.setVisibility(View.GONE);
            }*/
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       // NetWorkManager.cancelRequest(TAG);
    }

    public void destroyFragment(){
        if(getActivity()!=null){
            List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
         //   LogUtil.d(TAG+"集合中+》》"+fragments.size());
            for (int i=0;i<fragments.size();i++){
                Fragment fragment=fragments.get(i);
             //   if(fragment instanceof NewsFragment||fragment instanceof DisplayFragment || fragment instanceof CompanyFragment || fragment instanceof HeroFragment){

              //  }else{
              //     getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
             //   }
            }
            List<Fragment> fragmentss = getActivity().getSupportFragmentManager().getFragments();
          //  LogUtil.d(TAG+"集合中+》》》》"+fragmentss.size());
        }

    }
}
