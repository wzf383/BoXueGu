package cn.edu.gdmec.android.boxuegu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.edu.gdmec.android.boxuegu.R;

/**
 * Created by 38322 on 2018/1/29.
 */

public class AdBannerFragment extends Fragment {
    private  String ab;//广告
    private ImageView iv;//图片
    public static  AdBannerFragment newInstance(Bundle args){
        AdBannerFragment af=new AdBannerFragment();
        af.setArguments(args);
        return  af;
    }
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        Bundle arg=getArguments();
        //获取广告图片名称
        ab=arg.getString("ad");
    }
    @Override
    public  void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
    }
    @Override
    public  void onResume(){
        super.onResume();
        if(ab!=null){
            if("banner_1".equals(ab)){
                iv.setImageResource(R.drawable.banner_1);
            }else if("banner_2".equals(ab)){
                iv.setImageResource(R.drawable.banner_2);
            }else if("banner_3".equals(ab)){
                iv.setImageResource(R.drawable.banner_3);
            }

        }
    }
      @Override
    public  void onDestroy(){
          super.onDestroy();
          if(iv!=null){
              iv.setImageDrawable(null);
          }
      }
      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState){
          //创建广告图片控件
          iv=new ImageView(getActivity());
          ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                  ViewGroup.LayoutParams.FILL_PARENT);
          iv.setLayoutParams(lp);
          iv.setScaleType(ImageView.ScaleType.FIT_XY);
          return  iv;
      }
}
