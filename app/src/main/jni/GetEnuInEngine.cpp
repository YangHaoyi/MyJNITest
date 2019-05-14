/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :从引擎库文件获取枚举
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
#include <jni.h>
#define UNUSED_VAR(o) ((o) = (o))
#include "hyapi_car_speed_service.h"
#define REGISTER_CLASS "com/autoai/jni/GetEnuInEngineManager"


/**
 * 获取车速枚举通过int返回
 * @return 车速信息枚举
 */
static jint nativeGetCarSpeedUnit(JNIEnv *env, jclass thiz){
    UNUSED_VAR(env);
    UNUSED_VAR(thiz);
    return HyApi::CarSpeedService::getInstance()->getSpeedUnit();
}

/**
 * 设置车速枚举
 * @param unit 长度单位
 */
static void nativeSetCarSpeedUnit(JNIEnv *env, jclass thiz,jint unit){
    UNUSED_VAR(env);
    UNUSED_VAR(thiz);
    HYAPI_CAR_SPEED()->setSpeedUnit(static_cast<HyApi::SpeedUnit>(unit));
}


/**
 * 定义一个JNINativeMethod数组，其中的成员就是Java代码中对应的native方法
 * */
static JNINativeMethod gMethods[] = {
        {"nativeGetCarSpeedUnit","()I",(void*)nativeGetCarSpeedUnit},
        {"nativeSetCarSpeedUnit","(I)V",(void*)nativeSetCarSpeedUnit}
};

static int registerNativeMethods(JNIEnv *env, const char* className,JNINativeMethod* gMethods,int numMethods){
    jclass clazz;
    clazz = env->FindClass(REGISTER_CLASS);
    if (clazz == NULL) {
        return JNI_FALSE;
    }
    if (env->RegisterNatives(clazz,gMethods, numMethods) < 0) {
        return JNI_FALSE;
    }
    return JNI_TRUE;
}

/***
 * 注册native方法
 */
int registerCarSpeedNatives(JNIEnv* env) {
    if (!registerNativeMethods(env, REGISTER_CLASS, gMethods, sizeof(gMethods) / sizeof(gMethods[0]))) {
        return JNI_FALSE;
    }
    return JNI_TRUE;
}