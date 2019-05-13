/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :CarSpeed业务逻辑
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
#include <jni.h>
#define UNUSED_VAR(o) ((o) = (o))
#include "hyapi_car_speed_service.h"
#define REGISTER_CLASS "com/autoai/jni/CarSpeedManager"


/**
 * 获取车速
 */
static jint nativeGetCarSpeedUnit(JNIEnv *env, jclass thiz){
    UNUSED_VAR(env);
    UNUSED_VAR(thiz);
//    CARSPEED_SERVICE->setSpeedUnit(static_cast<HyApi::SpeedUnit>(1));
    HyApi::CarSpeedService::getInstance()->setSpeedUnit(static_cast<HyApi::SpeedUnit>(1));
    return HyApi::CarSpeedService::getInstance()->getSpeedUnit();
}

/**
 * 定义一个JNINativeMethod数组，其中的成员就是Java代码中对应的native方法
 * */
static JNINativeMethod gMethods[] = {
        {"nativeGetCarSpeedUnit","()I",(void*)nativeGetCarSpeedUnit}
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