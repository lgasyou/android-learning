#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_bit_lizeqing_jnitest_MainActivity_helloWorld(JNIEnv *env, jobject) {
    // TODO: implement helloWorld()
    std::string str = "Hello, world";
    return env->NewStringUTF(str.c_str());
}
extern "C"
JNIEXPORT jint JNICALL
Java_bit_lizeqing_jnitest_MainActivity_add(JNIEnv *env, jobject thiz, jint lhs, jint rhs) {
    return lhs + rhs;
}
