package com.yssz.justplay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yssz.justplay.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        MainActivity.actionStart(this)
        finish()
    }
}