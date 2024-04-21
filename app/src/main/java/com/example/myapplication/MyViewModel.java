package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> data;

    public MyViewModel(Application application){
        super();
        data = new MutableLiveData<>();
    }

    public MutableLiveData<String> getData() {
        return data;
    }

    public void fetchData() {
        String newdata = "New Data";
        data.postValue(newdata);
    }
}
