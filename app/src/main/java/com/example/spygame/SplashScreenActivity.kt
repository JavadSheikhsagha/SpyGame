package com.example.spygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text

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
        findViewById<ConstraintLayout>(R.id.parent).setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}