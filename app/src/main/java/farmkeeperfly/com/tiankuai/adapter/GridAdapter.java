package farmkeeperfly.com.tiankuai.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import farmkeeperfly.com.tiankuai.R;
import farmkeeperfly.com.tiankuai.SelectPictureActivity;

/**
 * Created by NTGJ on 2016/9/18.
 */
public class GridAdapter extends BaseAdapter {


    private Context mContext;
   private  GridAdapter mGridAdapter;
    private boolean isAdd;
    //存放所有选择的照片
    private List<String> allSelectedPicture = new ArrayList<String>();

    private onItemCheckClick mOnItemCheckClick;

    public void setOnItemCheckClick(onItemCheckClick onItemCheckClick) {
        mOnItemCheckClick = onItemCheckClick;
    }

    public GridAdapter(Context context, List<String> allSelectedPicture, boolean isAdd) {
        mContext = context;
        this.allSelectedPicture = allSelectedPicture;
        mGridAdapter=this;
        this.isAdd=isAdd;
    }

    //  public LayoutInflater layoutInflater = LayoutInflater.from(context);
    @Override
    public int getCount() {
        if(isAdd){
            return allSelectedPicture.size()== SelectPictureActivity.MAX_NUM?allSelectedPicture.size():allSelectedPicture.size()+1;
        }else{
            return allSelectedPicture==null?0:allSelectedPicture.size();
        }

    }

    @Override
    public Object getItem(int position) {
        return allSelectedPicture.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        ViewHolder holder = null ;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.childgrid_item, null);
            holder.image = (ImageView) convertView.findViewById(R.id.child_iv);
            holder.btn = (Button) convertView.findViewById(R.id.child_delete);
            holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == allSelectedPicture.size()) {
            holder.image.setImageBitmap(BitmapFactory.decodeResource(
                    mContext.getResources(), R.drawable.tianjialan));
            holder.btn.setVisibility(View.GONE);

            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemCheckClick!=null){
                        mOnItemCheckClick.onItemCheckClick();
                    }

                }
            });
            if (position == SelectPictureActivity.MAX_NUM) {
                holder.image.setVisibility(View.GONE);
            }
        } else {
            if(isAdd){
                ImageLoader.getInstance().displayImage("file://" + allSelectedPicture.get(position),
                        holder.image);
            }else{
                ImageLoader.getInstance().displayImage(allSelectedPicture.get(position),
                        holder.image);
                holder.btn.setVisibility(View.GONE);
            }


            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击后移除图片
                    allSelectedPicture.remove(position);

                    //更新UI
                    ( (GridView)parent).setAdapter(mGridAdapter);
                }
            });

        }
        return convertView;
    }
    public class ViewHolder {
        public ImageView image;
        public Button btn ;
    }

   public interface  onItemCheckClick{
        void onItemCheckClick();
    }
}
