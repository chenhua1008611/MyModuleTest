// IMyAidlInterface.aidl
package com.example.myapplication;

// Declare any non-default types here with import statements
import com.example.myapplication.Student;
import com.example.myapplication.IMylifeStyleListener;
import com.example.myapplication.IClientCallback;

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


    String getHelloWroldString();
    void setHelloWroldString(String string);

     void addStudent(in Student student);
     Student getStudent(int id);

     void registCallBack(IMylifeStyleListener il);
     void unregistCallBack(IMylifeStyleListener il);

     void registerClientCallback(IClientCallback callBack);


}