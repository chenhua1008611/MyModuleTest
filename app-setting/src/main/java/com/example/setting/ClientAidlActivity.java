package com.example.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.IClientCallback;
import com.example.myapplication.IMyAidlInterface;
import com.example.myapplication.IMylifeStyleListener;
import com.example.myapplication.Student;

public class ClientAidlActivity extends AppCompatActivity {
    private IMyAidlInterface myAidlInterface;
    private MylifeStyleListener mylifeStyleListener;

    //绑定状态
    private static boolean isBind = false;
    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                myAidlInterface.registCallBack(mylifeStyleListener);
                myAidlInterface.registerClientCallback(new ClientCallBack());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myAidlInterface = null;
            try {
                myAidlInterface.unregistCallBack(mylifeStyleListener);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            isBind = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientaidl);

        if (!isBind){
            Toast.makeText(this, "服务未连接", Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.setting_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //Android 5.0 之后需要直接定义包名
                intent.setComponent(new ComponentName("com.example.myapplication",
                        "com.example.myapplication.AidlTestService"));
                boolean re = bindService(intent,connection, Context.BIND_AUTO_CREATE);
                Log.i("xaeHu", "bindService: "+re);
            }
        });

        findViewById(R.id.setting_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (myAidlInterface != null){
                   try {
                       myAidlInterface.setHelloWroldString("hello world");

                   } catch (RemoteException e) {
                       throw new RuntimeException(e);
                   }
               }else {
                   Log.e("xaeHu", "btn2 onclick: myAidlInterface == null");
               }
            }
        });

        findViewById(R.id.setting_button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myAidlInterface != null){
                    try {
                        Toast.makeText(ClientAidlActivity.this,myAidlInterface.
                                getHelloWroldString(),Toast.LENGTH_SHORT).show();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }else {
                    Log.e("xaeHu", "btn3 onclick: myAidlInterface == null");
                }
            }
        });

        findViewById(R.id.setting_button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myAidlInterface != null){
                    try {
                        myAidlInterface.addStudent(new Student(1,"student1",26,0));
                        myAidlInterface.addStudent(new Student(2,"student2",27,1));

                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }else {
                    Log.e("xaeHu", "btn3 onclick: myAidlInterface == null");
                }
            }
        });

        findViewById(R.id.setting_button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myAidlInterface != null){
                    try {
                        Log.i("xaeHu", "getStudent1: "+myAidlInterface.getStudent(1));
                        Log.i("xaeHu", "getStudent2: "+myAidlInterface.getStudent(2));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }else {
                    Log.e("xaeHu", "btn3 onclick: myAidlInterface == null");
                }
            }
        });


    }

    class MylifeStyleListener extends IMylifeStyleListener.Stub{

        @Override
        public void OnCallBackHelloWroldString(String hello) throws RemoteException {
            Toast.makeText(ClientAidlActivity.this,"text="+hello,Toast.LENGTH_SHORT).show();
        }
    }

    public class ClientCallBack extends IClientCallback.Stub{

        @Override
        public void clientDiedCallBack() throws RemoteException {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
