package cn.edu.gdmec.android.boxuegu.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.edu.gdmec.android.boxuegu.R;

/**
 * Created by 38322 on 2018/1/29.
 */

public class ViewpagerIndicator extends LinearLayout {
      private  int mCount;//小圆点的个数
    private  int mIndex;//当前小圆点的位置
    private  Context context;
    public ViewpagerIndicator(Context context) {
        this(context,null);
    }
    public ViewpagerIndicator(Context context,  AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        setGravity(Gravity.CENTER);//设置此布局居中
    }
    /*
    * 设置滑动到当前小圆点时其他圆点的位置
    * */
    public void  setCurrentPosition(int currentIndex){
        mIndex=currentIndex;//当前小圆点
        removeAllViews();//移除界面上存在的view
        int pex=5;
        for (int i=0;i<mCount;i++){
            //创建一个ImageView控件来放置小圆点
            ImageView imageView=new ImageView(context);
            if(mIndex==i){//滑动到的当前界面
                //设置小圆点的图片为蓝色图片
                imageView.setImageResource(R.drawable.indicator_on);
            }else {
                //设置小圆点的图片为灰色图片
                imageView.setImageResource(R.drawable.indicator_off);
            }
            imageView.setPadding(pex,0,pex,0);
            addView(imageView);
        }
    }
    /*设置小圆点的数目*/
    public  void setCount(int count){
        this.mCount=count;
    }

}
