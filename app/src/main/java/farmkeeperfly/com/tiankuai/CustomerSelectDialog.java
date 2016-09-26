package farmkeeperfly.com.tiankuai;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static farmkeeperfly.com.tiankuai.R.id.gridview;

/**
 * Created by NTGJ on 2016/7/26.
 */
public class CustomerSelectDialog extends Dialog {

    private List<String> list;
    private String title;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CustomerSelectDialog(Context context, List<String> list, String title) {
        super(context);
        this.list = list;
        this.title = title;
    }

    public CustomerSelectDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomerSelectDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_select);



       /* WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用

        lp.width = (int) (d.widthPixels * 0.8); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(lp);
*/


        TextView dialog_title = (TextView) findViewById(R.id.dialog_title);
        ListView listView = (ListView) findViewById(R.id.dialog_listview);

        if(dialog_title!=null&&!TextUtils.isEmpty(title)){
            dialog_title.setText(title);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.dialog_select_item, list){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
               View view= super.getView(position, convertView, parent);
                TextView textView= (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.parseColor("#333333"));
                return view;
            }
        };
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(list.get(i),i);

                }
                dismiss();
            }
        });

    }


/*
    @Override
    public Window getWindow() {
        Window window = super.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        attributes.height= (int) (metrics.heightPixels*0.17);
        attributes.width= (int) (metrics.widthPixels*0.4);
        window.setAttributes(attributes);
        return window;
    }
*/

    public interface OnItemClickListener {
         void onItemClick(String string, int poition);
    }



    }
