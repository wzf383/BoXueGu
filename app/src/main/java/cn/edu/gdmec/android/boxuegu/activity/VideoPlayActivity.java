package cn.edu.gdmec.android.boxuegu.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import cn.edu.gdmec.android.boxuegu.R;

public class VideoPlayActivity extends AppCompatActivity {
     private VideoView videoView;
    private MediaController controller;
    private String videoPath;//本地视频地址
    private  int position;//传递视频详情界面点击的视频位置
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置界面全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
                );
        setContentView(R.layout.activity_video_play);
        //横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //获取从播放记录界面传递过来的视频地址
        videoPath=getIntent().getStringExtra("videoPath");
        position=getIntent().getIntExtra("position",0);
        init();
    }
    /*初始化UI控件*/
    public  void  init(){
        videoView=(VideoView)findViewById(R.id.videoView);
        controller=new MediaController(this);
        videoView.setMediaController(controller);
        play();
    }
    /*播放视频*/
    private void  play(){
        if(TextUtils.isEmpty(videoPath)){
            Toast.makeText(this,"本地没有此视频，暂无法播放",Toast.LENGTH_SHORT).show();
            return;
        }
        else  if(videoPath.equals("video11.mp4")) {
            String uri = "android.resource://" + getPackageName() + "/" + R.raw.video11;

            videoView.setVideoPath(uri);
        }else if(videoPath.equals("qq.mp4")) {
            String uri = "android.resource://" + getPackageName() + "/" + R.raw.qq;

            videoView.setVideoPath(uri);
        }
        videoView.start();
    }
    /*点击后退按钮*/
    @Override
    public  boolean onKeyDown(int keyCode, KeyEvent event){
        //把视频详情界面传递过来的被点击视频的位置传递回去
        Intent data=new Intent();
        data.putExtra("position",position);
        setResult(RESULT_OK,data);
        return super.onKeyDown(keyCode,event);
    }
}
