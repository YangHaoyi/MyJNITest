package com.autoai.jni.listener;

/**
 * @author : YangHaoYi on  2019/4/2815:06.
 * Email  :  yang.haoyi@qq.com
 * Description :JNI回调事件
 * Change : YangHaoYi on  2019/4/2815:06.
 * Version : V 1.0
 */
public interface JniEventListener {

    //Java回调
    void onJniEvent(CallBackEvent event, Object data);

    //回调事件枚举
    enum CallBackEvent{
        Test_callBack,
        Test_otherEvent
    }

}
