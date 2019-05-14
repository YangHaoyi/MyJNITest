package com.autoai.jni;

/**
 * @author : YangHaoYi on  2019/4/269:00.
 * Email  :  yang.haoyi@qq.com
 * Description :从引擎库获取字符串信息
 * Change : YangHaoYi on  2019/4/269:00.
 * Version : V 1.0
 */
public class GetStringInEngineManager {

    /** 定义单例 */
    private static GetStringInEngineManager instance = null;

    /** 获取单例 */
    public static GetStringInEngineManager getInstance(){
        if(instance == null){
            instance = new GetStringInEngineManager();
        }
        return instance;
    }

    /**
     *  提供公共方法 从引擎库文件中获取字符串信息
     * @return 库文件中赋值的字符串信息
     * **/
    public String getStringInEngine(){
        return nativeGetStringInEngine();
    }
    /** 调用Native方法 **/
    private native String nativeGetStringInEngine();

}
