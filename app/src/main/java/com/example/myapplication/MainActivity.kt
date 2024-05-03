package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import com.example.setting.SettingActivity
//import com.example.video.VideoActivity
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {

//    private var name0:String = "xiaoming";
//    private var name0: String? = null;
      private lateinit var name0:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        findViewById<View>(R.id.btn_video).setOnClickListener {
//            startActivity(Intent(this,VideoActivity::class.java))
//        }
//
//        findViewById<View>(R.id.btn_setting).setOnClickListener {
//            startActivity(Intent(this,SettingActivity::class.java))
//        }

        findViewById<View>(R.id.btn_flutter).setOnClickListener {
            startActivity(FlutterActivity.createDefaultIntent(this));
        }

    }
}