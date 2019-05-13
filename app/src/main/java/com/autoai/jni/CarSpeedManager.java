package com.autoai.jni;

/**
 * @author : YangHaoYi on  2019/5/1316:06.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on  2019/5/1316:06.
 * Version : V 1.0
 */
public class   CarSpeedManager {


    /** 单例 */
    private static final CarSpeedManager instance = new CarSpeedManager();

    /** 单例 */
    public static CarSpeedManager getInstance() {
        return instance;
    }

    public int getCarSpeed(){
        return nativeGetCarSpeedUnit();
    }

    private native int nativeGetCarSpeedUnit();

}
