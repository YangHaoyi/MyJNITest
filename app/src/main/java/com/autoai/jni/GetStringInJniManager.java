package com.autoai.jni;

/**
 * @author : YangHaoYi on  2019/4/2416:48.
 * Email  :  yang.haoyi@qq.com
 * Description :从JNI获取字符串信息
 * Change : YangHaoYi on  2019/4/2416:48.
 * Version : V 1.0
 */
public class GetStringInJniManager {

    /** 定义单例 */
    private static final GetStringInJniManager instance = new GetStringInJniManager();

    /** 获取单例 */
    public static GetStringInJniManager getInstance(){
        return instance;
    }

    /**
     *  提供公共方法 从JNI封装中获取字符串
     * @return JNI中赋值的字符串信息
     * **/
    public String getStringInJni(){
       return nativeGetStringInJNI();
    }

    /** 调用Native方法 **/
    private native String nativeGetStringInJNI();

}
