package com.damontung.healthclub;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;


import java.io.File;
import java.util.Objects;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class JuanFuActivity extends Activity {
    private VideoView mVideoView;
    private String TAG = "DGZ";
    private String path = Environment.getExternalStorageDirectory().getPath();//视频路径,内置存储卡
    private File pathEx = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
    private String moviesPath = Environment.DIRECTORY_MOVIES;
    private String videoType = "/Movies";
    private String pathTest = "http://live.3gv.ifeng.com/zixun.m3u8";
    //private String pathEx = Environment.getExternalStoragePublicDirectory().toString() + "/Movies";
    private String videoName = "/Movies/腹肌撕裂者 第1级.flv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_juan_fu);

        mVideoView = (VideoView) findViewById(R.id.video_view);
        Log.v(TAG, path + " ...path ");
        Log.v(TAG, moviesPath + " ...moviesPath ... Environment.DERECTORY_MOVIES ");
        Log.v(TAG, path + videoName + "...JuanFuActivity..video path...");

        if(path == ""){
            path = Environment.getExternalStorageDirectory().getPath();
        }else{
            mVideoView.setVideoPath(pathTest);
            mVideoView.setFocusable(true);
            //mVideoView.setVideoPath(path + videoType);
            mVideoView.setMediaController(new MediaController(this));
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setPlaybackSpeed(1.0f);
                }
            });
            mVideoView.start();
        }


    }

}
