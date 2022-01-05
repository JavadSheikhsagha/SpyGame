package com.example.spygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import android.content.SharedPreferences
import android.R.attr.repeatMode
import androidx.compose.runtime.key


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_splash_screen)
        fun View.blink(
            times: Int = Animation.INFINITE,
            duration: Long = 528L,
            offset: Long = 20L,
            minAlpha: Float = 0.0f,
            maxAlpha: Float = 1.0f,
            repeatMode: Int = Animation.REVERSE
        ) {
            startAnimation(AlphaAnimation(minAlpha, maxAlpha).also {
                it.duration = duration
                it.startOffset = offset
                it.repeatMode = repeatMode
                it.repeatCount = times
            })
        }
        var tap = findViewById<TextView>(R.id.tap)
        tap.blink()


        val walktrough_key = "WALKTHROUGH"
        val prefs = getSharedPreferences(walktrough_key, MODE_PRIVATE)

        findViewById<ConstraintLayout>(R.id.parent).setOnClickListener {
            if (!prefs.getBoolean("has_passed",false)) {
                startActivity(Intent(this, Walkthrough::class.java))
                finish()
            }else{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}