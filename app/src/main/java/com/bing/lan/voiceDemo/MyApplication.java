package com.bing.lan.voiceDemo;

import android.app.Application;

import com.bing.lan.voice.AudioUtils;
import com.iflytek.cloud.SpeechUtility;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 注意权限
        SpeechUtility.createUtility(getApplicationContext(), "appid=59e566ff");
        AudioUtils.getInstance().init(getApplicationContext());
    }
}
