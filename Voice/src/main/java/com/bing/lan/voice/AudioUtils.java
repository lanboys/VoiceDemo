package com.bing.lan.voice;

/**
 * Author: yxhuang
 * Date: 2017/6/22
 * Email: yxhuang@gmail.com
 */

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

/**
 * 描述：语音播放工具类
 * 作者：卜俊文
 * 创建：2016/8/19 09:07
 * 邮箱：344176791@qq.com
 */
public class AudioUtils {

    private static AudioUtils audioUtils;

    private SpeechSynthesizer mSpeechSynthesizer;

    public AudioUtils() {
    }

    /**
     * 描述:单例
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 14:38
     */
    public static AudioUtils getInstance() {
        if (audioUtils == null) {
            synchronized (AudioUtils.class) {
                if (audioUtils == null) {
                    audioUtils = new AudioUtils();
                }
            }
        }
        return audioUtils;
    }

    private InitListener myInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d("AudioUtils onInit", "InitListener init() code = " + code);
        }
    };

    /**
     * 描述:初始化语音配置
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 14:38
     */
    public void init(Context context) {

        //处理语音合成关键类
        mSpeechSynthesizer = SpeechSynthesizer.createSynthesizer(context, myInitListener);
        if (mSpeechSynthesizer != null) {
            setAudioParameter(mSpeechSynthesizer, "xiaoyan", 50, 50, 50);
        } else {
            Log.e("AudioUtils init", "mSpeechSynthesizer == null");
        }
    }

    public void speakText(String content) {
        speakText(content, "xiaoyan", 50, 50, 50);
    }

    /**
     * 描述:根据传入的文本转换音频并播放
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 14:39
     */
    public void speakText(String content, String voiceName, int pitch, int volume, int speed) {

        if (mSpeechSynthesizer == null) {
            Log.e("AudioUtils speakText", "mSpeechSynthesizer == null");
            return;
        } else {
            setAudioParameter(mSpeechSynthesizer, voiceName, pitch, volume, speed);
        }

        int code = mSpeechSynthesizer.startSpeaking(content, new SynthesizerListener() {
            @Override
            public void onSpeakBegin() {

            }

            @Override
            public void onBufferProgress(int i, int i1, int i2, String s) {

            }

            @Override
            public void onSpeakPaused() {

            }

            @Override
            public void onSpeakResumed() {

            }

            @Override
            public void onSpeakProgress(int i, int i1, int i2) {

            }

            @Override
            public void onCompleted(SpeechError speechError) {

            }

            @Override
            public void onEvent(int i, int i1, int i2, Bundle bundle) {

            }
        });
    }

    private static void setAudioParameter(SpeechSynthesizer speechSynthesizer,
            String voiceName, int pitch, int volume, int speed) {
        // http://www.xfyun.cn/doccenter/tts
        // 音量和语速支持0-100细粒度的设置，默认值为50

        //设置发音人
        speechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, voiceName);
        //设置音调
        speechSynthesizer.setParameter(SpeechConstant.PITCH, pitch + "");
        //设置音量
        speechSynthesizer.setParameter(SpeechConstant.VOLUME, volume + "");
        //设置语速
        speechSynthesizer.setParameter(SpeechConstant.SPEED, speed + "");
        //设置方言 与发音人有关  xiaomei  会说粤语
        speechSynthesizer.setParameter(SpeechConstant.ACCENT, "yueyu");
    }
}
