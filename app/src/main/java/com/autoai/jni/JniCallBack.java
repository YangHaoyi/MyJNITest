package com.autoai.jni;

import com.autoai.jni.listener.JniEventListener;

/**
 * @author : YangHaoYi on  2019/4/2616:55.
 * Email  :  yang.haoyi@qq.com
 * Description :CallBack事件接口封装
 * Change : YangHaoYi on  2019/4/2616:55.
 * Version : V 1.0
 */
public class JniCallBack {

    /** 单例 */
    private static final JniCallBack instance = new JniCallBack();

    /** 单例 */
    public static JniCallBack getInstance() {
        return instance;
    }

    /** Java回调接口 */
    private JniEventListener jniEventListener;

    /** JNI回调接口 */
    public interface TransferJniEventListener {
        void onJniEvent(int event, Object data);
    }

    /** JNI回调转换给Java回调 */
    private TransferJniEventListener eventListener = new TransferJniEventListener() {
        @Override
        public void onJniEvent(int event, Object data) {
            switch (event){
                case JNIEvent.callBackTest:
                    jniEventListener.onJniEvent(JniEventListener.CallBackEvent.Test_callBack,data);
                    break;
                case JNIEvent.callBackOther:
                    jniEventListener.onJniEvent(JniEventListener.CallBackEvent.Test_otherEvent,data);
                    break;
                default:
                    break;
            }
        }
    };

    /** 设置回调监听 */
    public void addEventListener(JniEventListener jniEventListener){
        this.jniEventListener = jniEventListener;
        //native注册回调监听
        nativeAddEventListener(eventListener);
    }

    /** 模拟回调 */
    public void doCallBack(){
        nativeCallBack();
    }

    private class JNIEvent {
        static final int callBackTest = 0;
        static final int callBackOther = 1;
    }

    /** native设置回调监听 */
    private native void nativeAddEventListener(TransferJniEventListener listener);
    /** native模拟回调 */
    private native void nativeCallBack();

}
