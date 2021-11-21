package com.example.spygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.asp.fliptimerviewlibrary.CountDownClock

class TimerActivity : AppCompatActivity() {

    private var TIME : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        TIME = intent.extras?.getInt("timer")!!

        findViewById<CountDownClock>(R.id.timerProgramCountdown).apply {
            startCountDown((TIME*60*1000L))
            this.setCountdownListener(object :CountDownClock.CountdownCallBack{
                override fun countdownAboutToFinish() {
//                    findViewById<Button>(R.id.btn_finish).setBackgroundColor(ContextCompat.getColor(this@TimerActivity,R.color.purple_700))
                }

                override fun countdownFinished() {
                    startActivity(Intent(this@TimerActivity,ResultActivity::class.java))
                    finish()
                }
            })
        }

        findViewById<Button>(R.id.btn_finish).setOnClickListener {
            startActivity(Intent(this,ResultActivity::class.java))
            finish()
        }
    }
}