package com.autoai.jni;

/**
 * @author : YangHaoYi on  2019/4/2416:48.
 * Email  :  yang.haoyi@qq.com
 * Description :对应Frst.cpp接口封装
 * Change : YangHaoYi on  2019/4/2416:48.
 * Version : V 1.0
 */
public class JniUtils {

    /** 提供公共方法 **/
    public String helloJni(){
       return nativePrint();
    }

    /** 调用Native方法 **/
    private native String nativePrint();

}
