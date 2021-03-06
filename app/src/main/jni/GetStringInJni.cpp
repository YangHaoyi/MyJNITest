/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :从JNI获取String
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
#include <jni.h>
#include <assert.h>
#include <cstdio>
#include <android/log.h>
#include "com_autoai_common.h"

#define UNUSED_VAR(o) ((o) = (o))
// 指定要注册的类
#define REGISTER_CLASS "com/autoai/jni/GetStringInJniManager"

JNIEXPORT jstring JNICALL nativeGetStringInJNI(JNIEnv *env,jclass clazz){
    UNUSED_VAR(clazz);
    jstring outSring;
    //使用宏判断
    #if defined(DEBUG_LOG)
        LOGD("这是Jni中的log");
        outSring = env->NewStringUTF("JNI赋值信息Debug(from GetStringInJni.cpp)");
    #else
        outSring = env->NewStringUTF("JNI赋值信息Release(from GetStringInJni.cpp)");
    #endif
    return outSring;
}

/**
 * 定义一个JNINativeMethod数组，其中的成员就是Java代码中对应的native方法
 * */
static JNINativeMethod gMethods[] = {
        {"nativeGetStringInJNI","()Ljava/lang/String;",(void*)nativeGetStringInJNI}
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
int registerNatives(JNIEnv* env) {
    if (!registerNativeMethods(env, REGISTER_CLASS, gMethods, sizeof(gMethods) / sizeof(gMethods[0]))) {
        return JNI_FALSE;
    }
    return JNI_TRUE;
}

