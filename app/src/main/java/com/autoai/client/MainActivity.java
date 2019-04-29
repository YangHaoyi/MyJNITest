package com.autoai.client;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.autoai.commonstylelibrary.view.dialog.CommonDialog;
import com.autoai.jni.JniCallBack;
import com.autoai.jni.JniUtils;
import com.autoai.jni.SecondTest;
import com.autoai.jni.bean.CallBackData;
import com.autoai.jni.listener.JniEventListener;
import com.autoai.myjnitest.R;

/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :JNI开发示例
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {

    /** 库文件名称 */
    private static final String JNI_LIB = "myjni";
    /** 从First.cpp获取字符串按钮 */
    private TextView tvGetMessageFromFirst;
    /** 从Second.cpp获取字符串按钮 */
    private TextView tvGetMessageFromSecond;
    /** 模拟从CallBack.cpp发生回调 */
    private TextView tvJniCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /** 初始化 */
    private void init(){
        System.loadLibrary(JNI_LIB);
        initView();
        initEvent();
    }

    /** 初始化View */
    private void initView(){
        tvGetMessageFromFirst = findViewById(R.id.tvGetMessageFromFirst);
        tvGetMessageFromSecond = findViewById(R.id.tvGetMessageFromSecond);
        tvJniCallBack = findViewById(R.id.tvJniCallBack);
    }

    /** 初始化事件 */
    private void initEvent(){
        tvGetMessageFromFirst.setOnClickListener(this);
        tvGetMessageFromSecond.setOnClickListener(this);
        tvJniCallBack.setOnClickListener(this);
        JniCallBack.getInstance().addEventListener(new JniEventListener() {
            @Override
            public void onJniEvent(CallBackEvent event, Object data) {
                switch (event){
                    case Test_callBack:
                        CallBackData callBackData = (CallBackData) data;
                        Log.w("CallBack", "Jni=============CallBack"+callBackData.toString());
                        break;
                    case Test_otherEvent:
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /** 显示提示框 */
    private void showNoticeDialog(String notice){
        new CommonDialog().setNotice(notice)
                .show(getSupportFragmentManager(), notice);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvGetMessageFromFirst:
                showNoticeDialog(new JniUtils().helloJni());
                break;
            case R.id.tvGetMessageFromSecond:
                showNoticeDialog(new SecondTest().printString());
                break;
            case R.id.tvJniCallBack:
                JniCallBack.getInstance().doCallBack();
                break;
            default:
                break;
        }
    }
}
