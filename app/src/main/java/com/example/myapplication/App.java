package com.example.myapplication;

import android.app.Application;
import android.os.Trace;
import android.widget.TextView;

import androidx.core.os.TraceCompat;
import androidx.core.os.TraceKt;

import com.kwai.koom.javaoom.KOOM;
import com.squareup.leakcanary.LeakCanary;

import io.flutter.view.FlutterMain;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TraceCompat.beginSection("Apponcreate");
        ModuleMediator.initModule(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        KOOM.init(this);
        TraceCompat.endSection();
//        FlutterMain.startInitialization(this);
    }
}
