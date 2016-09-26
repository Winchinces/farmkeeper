package farmkeeperfly.com.tiankuai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import farmkeeperfly.com.tiankuai.CustomerSelectDialog;
import farmkeeperfly.com.tiankuai.MyGridView;
import farmkeeperfly.com.tiankuai.R;
import farmkeeperfly.com.tiankuai.SelectPictureActivity;
import farmkeeperfly.com.tiankuai.adapter.GridAdapter;
import farmkeeperfly.com.tiankuai.base.BaseFragment;
import farmkeeperfly.com.tiankuai.city.CityDialog;
import farmkeeperfly.com.tiankuai.network.utils.LogUtil;
import farmkeeperfly.com.tiankuai.util.CustomTools;
import farmkeeperfly.com.tiankuai.util.PhotoUtil;

import static android.app.Activity.RESULT_OK;

/**
 * Created by NTGJ on 2016/9/23.
 */

public class CompletePlotDataFragment extends BaseFragment implements CityDialog.OnCityChooseListener, TextWatcher {
    private android.widget.EditText name;//姓名
    private android.widget.EditText tel;//电话
    private android.widget.EditText detail_address;//电话
    private android.widget.TextView address;//家庭住址
    private android.widget.EditText croparea;//亩数
    private android.widget.TextView cropname;//作物名称
    private android.widget.TextView grade;//坡度
    private android.widget.TextView terrain;//地势
    private android.widget.TextView plottype;//田地类型
    private android.widget.TextView barrier;//障碍物
    private android.widget.TextView work_area_photo;//作业图片
    private MyGridView gridview;//图片
    private android.widget.EditText note;//备注

    private List<String> cropNameList;//作物列表
    private List<String> terrainList;//地势列表
    private List<String> plotTypeList;//田块类型列表
    private List<String> barrierList;//障碍物列表
    private List<String> gradeList;//障碍物列表

    private CityDialog cityDialog;
    private GridAdapter gridAdapter;

    private static final int REQUEST_PICK = 0;
    private static final int PREFERED_PHOTO_WIDTH = 1280;// in pixels
    private static final int PREFERED_PHOTO_HEIGHT = 950;// in pixels
    private static final int PREFERED_PHOTO_SIZE = 300;// in KBytes


    //存放所有选择的照片
    private ArrayList<String> allSelectedPicture = new ArrayList<String>();
    //存放从选择界面选择的照片
    private ArrayList<String> selectedPicture = new ArrayList<String>();

    @Override
    protected int getContentView() {
        return R.layout.fragment_complete_data_plot;
    }

    @Override
    protected void findView(View view) {
        this.note = (EditText) view.findViewById(R.id.note);
        this.gridview = (MyGridView) view.findViewById(R.id.gridview);
        this.barrier = (TextView) view.findViewById(R.id.barrier);
        this.plottype = (TextView) view.findViewById(R.id.plot_type);
        this.terrain = (TextView) view.findViewById(R.id.terrain);
        this.grade = (TextView) view.findViewById(R.id.grade);
        this.work_area_photo = (TextView) view.findViewById(R.id.work_area_photo);
        this.cropname = (TextView) view.findViewById(R.id.crop_name);
        this.croparea = (EditText) view.findViewById(R.id.crop_area);
        this.address = (TextView) view.findViewById(R.id.address);
        this.tel = (EditText) view.findViewById(R.id.tel);
        this.name = (EditText) view.findViewById(R.id.name);
        this.detail_address = (EditText) view.findViewById(R.id.detail_address);
    }

    @Override
    protected void initView() {
        hideTabs();
        changerTitle(R.string.complete_plot_data);
        showRight("保存");
        work_area_photo.setText(Html.fromHtml(getString(R.string.work_area_photo  )+"<font color=\"#dcdcdc\">"+getString(R.string.photo_note)+"</font>"));

        address.setOnClickListener(this);
        cropname.setOnClickListener(this);
        grade.setOnClickListener(this);
        terrain.setOnClickListener(this);
        plottype.setOnClickListener(this);
        barrier.setOnClickListener(this);

        //亩数限制
        croparea.addTextChangedListener(this);

        //初始化数据
        initData();

        //选择图片
        gridAdapter = new GridAdapter(getContext(), allSelectedPicture, true);
        gridAdapter.setOnItemCheckClick(new GridAdapter.onItemCheckClick() {
            @Override
            public void onItemCheckClick() {
                selectClick();
            }
        });
        gridview.setAdapter(gridAdapter);

    }

    private void initData() {

        cropNameList = new ArrayList<>();
        terrainList = new ArrayList<>();
        plotTypeList = new ArrayList<>();
        barrierList = new ArrayList<>();
        gradeList = new ArrayList<>();
        //作物名称
        cropNameList.add("小麦");
        cropNameList.add("玉米");
        //地势
        terrainList.add("平地");
        terrainList.add("高地");
        terrainList.add("多山");

        //坡度
        gradeList.add("无坡度");
        gradeList.add("小坡度");
        gradeList.add("坡度较陡 ");
        gradeList.add("连续上下坡");
        //障碍物
        barrierList.add("小范围影响作业");
        barrierList.add("障碍物不影响作业");

        //田块类型
        plotTypeList.add("旱田");
        plotTypeList.add("水田");


        //城市三级联动
        cityDialog = new CityDialog();
        cityDialog.setOnCityChooseListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.titleLeftImage:
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
                break;
            case R.id.address://家庭住址
                if (cityDialog.isVisible()) {
                    cityDialog.dismiss();
                } else {
                    cityDialog.show(getActivity().getFragmentManager(), "city");
                }

                break;
            case R.id.crop_name://作物名称
                CustomerSelectDialog nameDialog = new CustomerSelectDialog(getContext(), cropNameList, "作物名称");
                nameDialog.show();
                nameDialog.setOnItemClickListener(new CustomerSelectDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(String string, int position) {
                        cropname.setText(string);
                    }
                });
                break;
            case R.id.grade://坡度
                CustomerSelectDialog gradeDialog = new CustomerSelectDialog(getContext(), gradeList, "坡度");
                gradeDialog.show();
                gradeDialog.setOnItemClickListener(new CustomerSelectDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(String string, int position) {
                        grade.setText(string);
                    }
                });

                break;
            case R.id.terrain://地势
                CustomerSelectDialog terrainDialog = new CustomerSelectDialog(getContext(), terrainList, "地势");
                terrainDialog.show();
                terrainDialog.setOnItemClickListener(new CustomerSelectDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(String string, int position) {
                        terrain.setText(string);
                    }
                });

                break;
            case R.id.plot_type://田地类型
                CustomerSelectDialog typeDialog = new CustomerSelectDialog(getContext(), plotTypeList, "田地类型");
                typeDialog.show();
                typeDialog.setOnItemClickListener(new CustomerSelectDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(String string, int position) {
                        plottype.setText(string);
                    }
                });

                break;
            case R.id.barrier://障碍物
                CustomerSelectDialog barrierDialog = new CustomerSelectDialog(getContext(), barrierList, "障碍物");
                barrierDialog.show();
                barrierDialog.setOnItemClickListener(new CustomerSelectDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(String string, int position) {
                        barrier.setText(string);
                    }
                });
                break;

        }
    }

    /**
     * 城市取消回调
     */
    @Override
    public void onCancelChooseClick() {

    }

    /**
     * 城市选中回调
     *
     * @param provice  省
     * @param city     市
     * @param distinct 县
     */
    @Override
    public void onAcceptClick(String provice, String city, String distinct) {
        address.setText(new StringBuilder().append(provice).append(city).append(distinct));
    }


    /**
     * 图片点击监听
     */
    private void selectClick() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), SelectPictureActivity.class);

        Bundle bundle = new Bundle();
        bundle.putStringArrayList("allSelectedPicture", allSelectedPicture);
        intent.putExtras(bundle);

        if (allSelectedPicture.size() < SelectPictureActivity.MAX_NUM) {
            startActivityForResult(intent, REQUEST_PICK);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (REQUEST_PICK == requestCode && resultCode == RESULT_OK) {
            selectedPicture = (ArrayList) data.getSerializableExtra(SelectPictureActivity.INTENT_SELECTED_PICTURE);
            for (String str : selectedPicture) {
                if (!allSelectedPicture.contains(str)) {
                    PhotoUtil.compressImageAndSaveAsJpg(PhotoUtil
                            .decodeBitmapFromFile(str, PREFERED_PHOTO_WIDTH, PREFERED_PHOTO_HEIGHT), PREFERED_PHOTO_SIZE, str);
                    allSelectedPicture.add(str);
                    gridview.setAdapter(gridAdapter);
                }
            }
        }
    }





    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int i2) {
        LogUtil.d(TAG, charSequence.toString());
        croparea.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        String text = charSequence.toString();
        if (!TextUtils.isEmpty(text)) {
            int index = text.indexOf(".");
            if (index == 0) {
                CustomTools.showToast("不能以小数点开始", false);
                croparea.setText("");
            } else {
                float num = Float.parseFloat(charSequence.toString());
                LogUtil.d(TAG, "start>>" + start);
                LogUtil.d(TAG, "before>>" + before);
                if (num > 99999.9) {
                    LogUtil.d(TAG, "超过最大数");
                    int len = text.length() - 1;
                    croparea.setFilters(new InputFilter[]{new InputFilter.LengthFilter(len)});
                    LogUtil.d(TAG, ">>>>>>" + text.substring(0, len));
                    croparea.setSelection(0);
                    croparea.setText(text.substring(0, len));
                }
                if (text.contains(".")) {
                    croparea.setFilters(new InputFilter[]{new InputFilter.LengthFilter(text.indexOf(".") + 2)});
                }

            }

        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String text = editable.toString();
        int len = editable.toString().length();
        if (len == 1 && text.equals("0")) {
//            s.clear();
            CustomTools.showToast("亩数不能为0", false);
        }
        if (text.startsWith("0")) {
            editable.delete(0, 1);
        }
    }

}
