package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.setting.SettingActivity
import com.example.video.VideoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_video).setOnClickListener {
            startActivity(Intent(this,VideoActivity::class.java))
        }

        findViewById<View>(R.id.btn_setting).setOnClickListener {
            startActivity(Intent(this,SettingActivity::class.java))
        }

    }
}