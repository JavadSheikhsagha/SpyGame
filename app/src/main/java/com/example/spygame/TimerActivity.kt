package com.example.spygame

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.asp.fliptimerviewlibrary.CountDownClock
import android.os.CountDownTimer
import android.widget.*
import com.google.android.material.progressindicator.CircularProgressIndicator
import kotlin.math.log


class TimerActivity : AppCompatActivity() {

    var isplay = true
    lateinit var play: MediaPlayer
    lateinit var countdown: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        play = MediaPlayer.create(this@TimerActivity, R.raw.spybit)
        countdown = MediaPlayer.create(this@TimerActivity, R.raw.tencountdown)
        play.start()
        play.isLooping = true
        startTimer(intent.getIntExtra("timer", 1))
        findViewById<Button>(R.id.btn_finish).setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
            finish()
            play.stop()
            countdown.stop()
        }

        findViewById<ImageView>(R.id.volume).setOnClickListener {
            if (isplay) {
                play.isLooping = false
                play.pause()
                findViewById<ImageView>(R.id.volume).setImageResource(
                    R.drawable.mute
                )
                isplay = false
            }
            else{
                play.start()
                play.isLooping = true
                findViewById<ImageView>(R.id.volume).setImageResource(
                    R.drawable.volume
                )
                isplay = true
            }
        }
    }

    private fun startTimer(minuti: Int) {
        object : CountDownTimer((60 * minuti * 1000).toLong(), 500) {
            // 500 means, onTick function will be called at every 500 milliseconds
            override fun onTick(leftTimeInMilliseconds: Long) {
                val seconds = leftTimeInMilliseconds / 1000
                findViewById<TextView>(R.id.timetext).text =
                    String.format("%02d", seconds / 60) + ":" + String.format(
                        "%02d",
                        seconds % 60
                    )
                // format the textview to show the easily readable format
                if (findViewById<TextView>(R.id.timetext).text.equals("00:10")) {
                    play.stop()
                    countdown.start()

                }
            }

            override fun onFinish() {
                if (findViewById<TextView>(R.id.timetext).text.equals("00:00")) {
                    findViewById<TextView>(R.id.timetext).text = "پایان"
                    startActivity(Intent(this@TimerActivity,ResultActivity::class.java))
                }

            }
        }.start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        play.stop()
    }
}