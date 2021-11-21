package com.example.spygame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private val LOCATION = RevealActivity.LOCATION

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        findViewById<TextView>(R.id.txtResult).text = "کلمه مورد نظر ${LOCATION} است."
        findViewById<TextView>(R.id.txtSpy).apply {
            var spyText = ""
            RevealActivity.playerList.forEachIndexed { index, player ->
                if (player.type == PlayerType.SPY)
                    spyText += "بازیکن شماره ${index + 1} جاسوس است.\n"
            }
            text = spyText
        }
        findViewById<Button>(R.id.btnFinish).setOnClickListener {
            finish()
        }
    }
}