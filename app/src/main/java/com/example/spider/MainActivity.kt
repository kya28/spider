package com.example.spider

import android.content.Intent
import android.content.pm.FeatureInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPlayIcon : ImageView = findViewById(R.id.button_play_icon)
        val intentPlayActivity = Intent(this, PlayActivity::class.java)
        buttonPlayIcon.setOnClickListener {
            startActivity(intentPlayActivity)
        }
    }
}