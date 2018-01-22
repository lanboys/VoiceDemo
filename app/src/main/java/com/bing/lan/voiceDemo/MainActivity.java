package com.bing.lan.voiceDemo;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bing.lan.voice.AudioUtils;

public class MainActivity extends AppCompatActivity {

    private EditText edt_input;
    private Button btn_play;
    private int speed = 20;
    private AudioManager mAudioManager;
    double max = 0;
    double current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_input = (EditText) findViewById(R.id.edt_input);
        edt_input.setText("支付宝口碑收款10000元");
        btn_play = (Button) findViewById(R.id.btn_play);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String content = edt_input.getText().toString().trim();
                if (!TextUtils.isEmpty(content)) {
                    //音乐音量 语音播报的音量
                    max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                    current = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                    Log.e("btn_play", "音乐音量 max: " + max + ", current: " + current);

                    AudioUtils.getInstance().speakText(content, "xiaoyan", 50, 50, speed);
                    Log.e("btn_play", "speed: " + speed);
                    speed += 10;
                }
            }
        });
    }
}
