package com.example.spygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
     var citizenCounter = 3
     var spyCounter = 1
     var timeRemain = 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var citiIncrease = findViewById<TextView>(R.id.ci)
         var citiDecrease = findViewById<TextView>(R.id.cd)
         var citizenNumber = findViewById<TextView>(R.id.citizenNumber)
         var spyIncrease = findViewById<TextView>(R.id.si)
         var spyDecrease = findViewById<TextView>(R.id.sd)
         var spyNumber = findViewById<TextView>(R.id.spyNumber)
         var timeIncrease = findViewById<TextView>(R.id.ti)
         var timeDecrease = findViewById<TextView>(R.id.td)
         var time = findViewById<TextView>(R.id.timing)

        citiIncrease.setOnClickListener{
            if (citizenCounter<10){
                citizenCounter ++
                citizenNumber.setText(citizenCounter.toString())
            }
        }
        citiDecrease.setOnClickListener {
            if (citizenCounter > 3){
                citizenCounter --
                citizenNumber.setText(citizenCounter.toString())
            }
        }
        spyIncrease.setOnClickListener {
            if (spyCounter<4){
                spyCounter ++
                spyNumber.setText(spyCounter.toString())
            }
        }
        spyDecrease.setOnClickListener {
            if (spyCounter>1){
                spyCounter --
                spyNumber.setText(spyCounter.toString())
            }
        }
        timeIncrease.setOnClickListener {
            if (timeRemain<15){
                timeRemain ++
                time.setText(timeRemain.toString())
            }
        }
        timeDecrease.setOnClickListener {
            if (timeRemain>4){
                timeRemain --
                time.setText(timeRemain.toString())
            }
        }


        findViewById<Button>(R.id.button5).setOnClickListener {
            startActivity(Intent(this,RevealActivity::class.java).apply {
                putExtra("spyC",spyCounter)
                putExtra("citiC",citizenCounter)
                putExtra("time",timeRemain)
            })
        }

        findViewById<ImageView>(R.id.info).setOnClickListener {
            startActivity(Intent(this,InfoActivity::class.java))
            finish()
        }

    }
}