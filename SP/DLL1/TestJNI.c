#include <jni.h>

#include "TestJNI.h"

#include <stdio.h>



#include <Math.h>
#define PI 3.14159265

JNIEXPORT jint JNICALL Java_TestJNI_add (JNIEnv *env, jobject object, jint n1,jint n2) 

{
 
  jint res;
 
  res=n1+n2;
 
  return res;

}

JNIEXPORT jint JNICALL Java_TestJNI_sub (JNIEnv *env, jobject object, jint n1,jint n2) 

{
 
  jint res;
 
  res=n1-n2;
 
  return res;

}

JNIEXPORT jint JNICALL Java_TestJNI_mul (JNIEnv *env, jobject object, jint n1,jint n2) 

{
 
  jint res;
 
  res=n1*n2;
 
  return res;

}

JNIEXPORT jint JNICALL Java_TestJNI_div (JNIEnv *env, jobject object, jint n1,jint n2) 

{
 
  jint res;
 
  res=n1/n2;
 
  return res;

}

JNIEXPORT jdouble JNICALL Java_TestJNI_sin (JNIEnv *env, jobject object, jdouble x) 

{
 
  jdouble res, val;
 
  val = PI/180;
  res=sin(x*val);
 
  return res;

}

JNIEXPORT jdouble JNICALL Java_TestJNI_cos (JNIEnv *env, jobject object, jdouble x) 

{
 
  jdouble res, val;
 
  val = PI/180;
  res=cos(x*val);
 
  return res;

}

JNIEXPORT jdouble JNICALL Java_TestJNI_log10 (JNIEnv *env, jobject object, jdouble x) 

{
 
  jdouble res;
 
  
  res=log10(x);
 
  return res;

}

