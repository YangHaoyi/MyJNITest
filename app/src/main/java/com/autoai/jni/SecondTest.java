package com.autoai.jni;

/**
 * @author : YangHaoYi on  2019/4/269:00.
 * Email  :  yang.haoyi@qq.com
 * Description :对应Second.cpp接口封装
 * Change : YangHaoYi on  2019/4/269:00.
 * Version : V 1.0
 */
public class SecondTest {

    /** 提供公共方法 **/
    public String printString(){
        return nativeSecondPrint();
    }
    /** 调用Native方法 **/
    private native String nativeSecondPrint();

}
