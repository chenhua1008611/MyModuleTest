package com.example.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.HashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TestActivity extends AppCompatActivity {

    private MyViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Handler ss
//        BroadcastReceiver
//        Condition condition = Lock.get
        MessageQueue queue = Looper.myQueue();
//        Looper
//        queue.next();
        this.sendBroadcast(null);
        RecyclerView re = new RecyclerView(this);
//        Double
//        HashSet
//        Integer
//        Glide.with( this).load( "https://manhua.qpic.cn/vertical/0/07_22_36_afe651da2ab940d0e257a1ec894bd992_1504795010150.jpg/420")
//                .circleCrop()
//                .apply(RequestOptions.bitmapTransform(RoundCorner( this,rightTop = 20f)))
//                .into(iv) //右上角
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String newdata) {

//                TextView tx = findViewById();
//                tx.setText(newdata);
            }
        });


    }

}
