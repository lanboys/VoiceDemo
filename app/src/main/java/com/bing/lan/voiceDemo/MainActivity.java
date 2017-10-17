package com.bing.lan.voiceDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bing.lan.voice.AudioUtils;

public class MainActivity extends AppCompatActivity {

    private EditText edt_input;
    private Button btn_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_input = (EditText) findViewById(R.id.edt_input);
        edt_input.setText("支付宝口碑收款10000元");
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = edt_input.getText().toString().trim();
                if (!TextUtils.isEmpty(content)) {
                    AudioUtils.getInstance().speakText(content);
                }
            }
        });
    }
}
