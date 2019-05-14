package com.autoai.jni;

/**
 * @author : YangHaoYi on  2019/5/1316:06.
 * Email  :  yang.haoyi@qq.com
 * Description :从引擎库获取枚举信息
 * Change : YangHaoYi on  2019/5/1316:06.
 * Version : V 1.0
 */
public class GetEnuInEngineManager {

    /** Holder单例
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     * */
    private static class GetEnuInEngineManagerHolder{
        //静态初始化器，由JVM来保证线程安全
        private static GetEnuInEngineManager instance = new GetEnuInEngineManager();
    }

    /** 获取单例 */
    public static GetEnuInEngineManager getInstance() {
        return GetEnuInEngineManagerHolder.instance;
    }

    /** 获取车速信息 */
    public int getCarSpeed(){
        return nativeGetCarSpeedUnit();
    }

    /**
     *  设置车速信息
     * @param unit 车速单位
     * */
    public void setCarSpeed(int unit){
        nativeSetCarSpeedUnit(unit);
    }

    /** native方法  获取车速*/
    private native int nativeGetCarSpeedUnit();
    /** native方法  设置车速*/
    private native void nativeSetCarSpeedUnit(int unit);
}
