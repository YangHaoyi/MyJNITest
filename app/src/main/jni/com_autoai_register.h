/**
 * @author : YangHaoYi on  2019/4/2610:40.
 * Email  :  yang.haoyi@qq.com
 * Description :注册头文件
 * Change : YangHaoYi on  2019/4/2610:40.
 * Version : V 1.0
 */
#include <jni.h>

#ifndef MYJNITEST_COM_AUTOAI_REGISTER_H
#define MYJNITEST_COM_AUTOAI_REGISTER_H

#endif //MYJNITEST_COM_AUTOAI_REGISTER_H

//为Register调用First注册提供
int registerNatives(JNIEnv *env);

//为Register调用Second注册提供
int registerSecondNatives(JNIEnv *env);

//为Register调用CarSpeed注册提供
int registerCarSpeedNatives(JNIEnv *env);

//为Register调用CallBack注册提供
int registerCallBackNatives(JNIEnv *env);