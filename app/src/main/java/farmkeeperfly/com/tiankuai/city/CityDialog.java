package farmkeeperfly.com.tiankuai.city;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import farmkeeperfly.com.tiankuai.R;


/**
 * Created by NTGJ on 2016/8/12.
 */
public class CityDialog extends DialogFragment implements View.OnClickListener {


    ScrollerNumberPicker provincePicker;
    ScrollerNumberPicker cityPicker;
    ScrollerNumberPicker counyPicker;

    private OnCityChooseListener onCityChooseListener;

    public void setOnCityChooseListener(OnCityChooseListener onCityChooseListener) {
        this.onCityChooseListener = onCityChooseListener;
    }

    public interface OnCityChooseListener{
        public void onCancelChooseClick();
        public void onAcceptClick(String provice, String city, String distinct);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.CustomDatePickerDialog);

        //
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // must be called
        // before set
        // content
        dialog.setContentView(R.layout.addressdialog);
        dialog.setCanceledOnTouchOutside(true);

        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);


        LinearLayout addressdialog_confirm = (LinearLayout)dialog.findViewById(R.id.addressdialog_confirm);
        LinearLayout addressdialog_cancel = (LinearLayout)dialog.findViewById(R.id.addressdialog_cancel);

        provincePicker = (ScrollerNumberPicker)dialog.findViewById(R.id.province);

        cityPicker = (ScrollerNumberPicker)dialog.findViewById(R.id.city);

        counyPicker = (ScrollerNumberPicker)dialog.findViewById(R.id.couny);
        addressdialog_cancel.setOnClickListener(this);
        addressdialog_confirm.setOnClickListener(this);

        return dialog;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.addressdialog_cancel:
                dismiss();
                if(onCityChooseListener!=null){
                    onCityChooseListener.onCancelChooseClick();
                }
                break;
            case R.id.addressdialog_confirm:
                dismiss();
                if(onCityChooseListener!=null){
                    onCityChooseListener.onAcceptClick(provincePicker.getSelectedText(),cityPicker.getSelectedText(),counyPicker.getSelectedText());
                }
                break;

        }
    }


}
