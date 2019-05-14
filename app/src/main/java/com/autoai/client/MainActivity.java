package com.autoai.client;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.autoai.commonstylelibrary.view.dialog.CommonDialog;
import com.autoai.jni.GetEnuInEngineManager;
import com.autoai.jni.GetStringInEngineManager;
import com.autoai.jni.JniCallBackManager;
import com.autoai.jni.GetStringInJniManager;
import com.autoai.jni.bean.CallBackData;
import com.autoai.jni.enu.CarSpeedUnitType;
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
    /** 获取JNI赋值的字符串按钮 */
    private TextView tvGetMessageFromJNI;
    /** 获取从引擎库赋值的字符串按钮 */
    private TextView tvGetMessageFromEngine;
    /** 模拟从CallBack.cpp发生回调 */
    private TextView tvJniCallBack;
    /** 从引擎库端获取枚举变量按钮 */
    private TextView tvGetCarSpeed;

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
        initData();
        initEvent();
    }

    /** 初始化View */
    private void initView(){
        tvGetMessageFromJNI = findViewById(R.id.tvGetMessageFromJNI);
        tvGetMessageFromEngine = findViewById(R.id.tvGetMessageFromEngine);
        tvJniCallBack = findViewById(R.id.tvJniCallBack);
        tvGetCarSpeed = findViewById(R.id.tvGetCarSpeed);
    }

    /** 初始化数据 */
    private void initData(){
        GetEnuInEngineManager.getInstance().setCarSpeed(2);
    }

    /** 初始化事件 */
    private void initEvent(){
        tvGetMessageFromJNI.setOnClickListener(this);
        tvGetMessageFromEngine.setOnClickListener(this);
        tvJniCallBack.setOnClickListener(this);
        tvGetCarSpeed.setOnClickListener(this);
        JniCallBackManager.getInstance().addEventListener(new JniEventListener() {
            @Override
            public void onJniEvent(CallBackEvent event, Object data) {
                switch (event){
                    case Test_callBack:
                        CallBackData callBackData = (CallBackData) data;
                        Log.w("CallBack", "JniCallBack"+callBackData.toString());
                        showNoticeDialog("JniCallBack"+callBackData.toString());
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

    /** 点击事件 */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //从JNI获取String
            case R.id.tvGetMessageFromJNI:
                showNoticeDialog(GetStringInJniManager.getInstance().getStringInJni());
                break;
            //从引擎库获取String
            case R.id.tvGetMessageFromEngine:
                showNoticeDialog(GetStringInEngineManager.getInstance().getStringInEngine());
                break;
            //模拟JNI回调
            case R.id.tvJniCallBack:
                JniCallBackManager.getInstance().doCallBack();
                break;
            //从引擎库获取枚举
            case R.id.tvGetCarSpeed:
                showNoticeDialog(getString(R.string.app_car_speed_is)+
                        CarSpeedUnitType.get(GetEnuInEngineManager.getInstance().getCarSpeed()).getUnit());
                break;
            default:
                break;
        }
    }
}
