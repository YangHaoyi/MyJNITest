/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :Second业务逻辑
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
#include <jni.h>
#include "com_autoai_common.h"

#define REGISTER_CLASS "com/autoai/jni/SecondTest"

#define UNUSED_VAR(o) ((o) = (o))

JNIEXPORT jstring JNICALL nativeSecondPrint(JNIEnv *env, jclass clazz){
    UNUSED_VAR(clazz);
    return env->NewStringUTF("JNI_______输出信息(from Second.cpp)");
}

static JNINativeMethod gMethods[] = {
        {"nativeSecondPrint","()Ljava/lang/String;",(void*)nativeSecondPrint}
};

static int registerNativeMethods(JNIEnv *env, const char* className,JNINativeMethod* gMethods,int numMethods){
    jclass clazz;
    clazz = env->FindClass(REGISTER_CLASS);
    if(clazz == NULL){
        return JNI_FALSE;
    }
    if(env->RegisterNatives(clazz,gMethods,numMethods)<0){
        return JNI_FALSE;
    }
    return JNI_TRUE;
}

 int registerSecondNatives(JNIEnv *env){
    if(!registerNativeMethods(env,REGISTER_CLASS,gMethods, sizeof(gMethods)/ sizeof(gMethods[0]))){
        return JNI_FALSE;
    }
    return JNI_TRUE;
}

