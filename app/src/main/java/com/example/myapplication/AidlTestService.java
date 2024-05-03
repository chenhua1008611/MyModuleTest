package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class AidlTestService extends Service {

    private String hello;
    private Map<Integer,Student> studentMap;
    private IMylifeStyleListener mylifeStyleListener;
    private RemoteCallbackList<IClientCallback> callbackList;
    private static final String TAG = "AidlTestService";


    @Override
    public void onCreate() {
        super.onCreate();
        hello = "hello";
        callbackList = new RemoteCallbackList<IClientCallback>(){
            @Override
            public void onCallbackDied(IClientCallback callback) {
                Log.e(TAG, "onCallbackDied: ");
            }
        };
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends IMyAidlInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.i("xaeHu", "basicTypes: " +
                    "\nanInt = "+anInt
                    +"\naLong = "+aLong
                    +"\naBoolean = "+aBoolean
                    +"\naFloat = "+aFloat
                    +"\naDouble = "+aDouble
                    +"\naString = "+aString
            );
        }

        @Override
        public String getHelloWroldString() throws RemoteException {
            return hello;
        }

        @Override
        public void setHelloWroldString(String string) throws RemoteException {
            hello = string;
            if (mylifeStyleListener != null){
                mylifeStyleListener.OnCallBackHelloWroldString(hello);
            }

        }

        @Override
        public void addStudent(Student student) throws RemoteException {
            Log.i("xaeHu", "addStudent: "+student);
            if(studentMap == null){
                studentMap = new HashMap<>();
            }
            studentMap.put(student.getId(), student);

        }

        @Override
        public Student getStudent(int id) throws RemoteException {
            if(studentMap != null){
                Student student = studentMap.get(id);
                Log.i("xaeHu", id + " -> getStudent: "+student);
                return student;
            }
            Log.i("xaeHu", id + " -> getStudent: null");

            return null;
        }

        @Override
        public void registCallBack(IMylifeStyleListener il) throws RemoteException {
            if (il != null){
                mylifeStyleListener = il;
            }
        }

        @Override
        public void unregistCallBack(IMylifeStyleListener il) throws RemoteException {
            if (il != null){
                mylifeStyleListener = null;
            }
        }

        @Override
        public void registerClientCallback(IClientCallback callBack) throws RemoteException {
            Log.e(TAG, "registerClientCallback: ");
            callbackList.register(callBack);
        }


    }

}
