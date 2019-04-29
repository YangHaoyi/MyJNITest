/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :JNI回调示例
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */

#include <jni.h>
#include "com_autoai_common.h"

#define REGISTER_CLASS "com/autoai/jni/JniCallBack"

typedef struct Mbapi2ClientEventJNI {
    jobject initEventCBClass;
    jmethodID onEventMethod;
} Mbapi2ClientEventJNI;

static Mbapi2ClientEventJNI g_Mbapi2ClientEventJNI = {0};

/**  添加CallBack监听  **/
static void nativeAddEventListener(JNIEnv *env, jclass thiz, jobject callback){
    UNUSED_VAR(thiz);
    Mbapi2ClientEventJNI *o = &g_Mbapi2ClientEventJNI;
    if (callback != NULL) {
        jclass initTempCBClass = env->GetObjectClass(callback);
        if (o->initEventCBClass != NULL) {
            env->DeleteGlobalRef(o->initEventCBClass);
            o->initEventCBClass = NULL;
        }
        o->initEventCBClass = env->NewGlobalRef(callback);
        o->onEventMethod = env->GetMethodID(initTempCBClass, "onJniEvent", "(ILjava/lang/Object;)V");
        env->DeleteLocalRef(initTempCBClass);
    }
}

/**
 * 获取CallBack数据
 * _getCallBackData需要在调用函数naticeCallBack之上
 * */
static jobject _getCallBackData(JNIEnv *env) {
    //或得CallBackData类引用
    jclass stucls = env->FindClass("com/autoai/jni/bean/CallBackData");
    //获得得该类型的构造函数  函数名为 <init> 返回类型必须为 void 即 V
    jmethodID constrocMID = env->GetMethodID(stucls,"<init>","(Ljava/lang/String;II)V");
    //构造一个对象，调用该类的构造函数，并且传递参数
    jstring str = env->NewStringUTF(" come from Native ");
    jobject callbackData = env->NewObject(stucls,constrocMID,str,11,12);
    return callbackData;
}

/**  JNI回调Java函数  **/
JNIEXPORT void JNICALL nativeCallBack(JNIEnv *env, jclass clazz){
    UNUSED_VAR(clazz);
    Mbapi2ClientEventJNI *o = &g_Mbapi2ClientEventJNI;
    jint event = 0;
    jobject resultObj = NULL;
    resultObj = _getCallBackData(env);
    env->CallVoidMethod(o->initEventCBClass, o->onEventMethod, (jint) event,
                        resultObj);
}


/**  注册  **/
static JNINativeMethod gMethods[] = {
        {"nativeAddEventListener",    "(Lcom/autoai/jni/JniCallBack$TransferJniEventListener;)V", (void *) nativeAddEventListener},
        {"nativeCallBack","()V",(void*)nativeCallBack}
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

int registerCallBackNatives(JNIEnv *env){
    if(!registerNativeMethods(env,REGISTER_CLASS,gMethods, sizeof(gMethods)/ sizeof(gMethods[0]))){
        return JNI_FALSE;
    }
    return JNI_TRUE;
}


