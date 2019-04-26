/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :注册类
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
#include <jni.h>
#include <cassert>
#include "com_autoai_common.h"
#include "com_autoai_register.h"

/**
 * 动态注册
 */
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env = NULL;
    jint result = -1;
    if (vm-> GetEnv((void**) &env, JNI_VERSION_1_6) != JNI_OK) {
        return -1;
    }
    assert(env != NULL);
    //注册
    registerSecondNatives(env);
    registerNatives(env);
    result = JNI_VERSION_1_6;

    return result;

}
