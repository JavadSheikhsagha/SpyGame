package com.example.spygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.spygame.databinding.ActivityMainBinding
import com.example.spygame.databinding.ActivityWalktroughBinding
import com.suddenh4x.ratingdialog.AppRating
import com.suddenh4x.ratingdialog.preferences.RatingThreshold

class MainActivity : AppCompatActivity() {
     var citizenCounter = 3
     var spyCounter = 1
     var timeRemain = 4
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        AppRating.Builder(this)
            .setMinimumLaunchTimes(5)
            .setMinimumDays(7)
            .setMinimumLaunchTimesToShowAgain(5)
            .setMinimumDaysToShowAgain(10)
            .setRatingThreshold(RatingThreshold.FOUR)
            .showIfMeetsConditions()


        findViewById<ImageView>(R.id.rate_us).setOnClickListener {
            AppRating.Builder(this)
                .showNow()
        }

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


        findViewById<Button>(R.id.start_button).setOnClickListener {
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