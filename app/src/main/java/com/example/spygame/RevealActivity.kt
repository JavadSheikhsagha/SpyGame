package com.example.spygame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import java.util.*
import kotlin.random.Random

class RevealActivity : AppCompatActivity() {

    private var citizenCounter: Int = 0
    private var spyCounter: Int = 0
    private var timeRemaining: Int = 0

    private var isShowing = false

    companion object {
        val playerList = mutableListOf<Player>()
        var locations = listOf("کشتی", "بیمارستان", "بانک", "رستوران", "فرودگاه", "مدرسه" , "آرایشگاه" , "سالن ورزشی" , "باشگاه" , "فروشگاه" , "قطار" , "اتوبوس" , "آزمایشگاه" , "خیاطی" , "کفاشی" , "طلافروشی" , "مترو" , "دانشگاه" , "پیش دبستانی" , "دفتر وکالت" , "دامپزشکی" , "باغ وحش" , "گلخونه" , "گل فروشی" , "تیمارستان" , "خوابگاه" , "داروخانه" , "عکاسی" , "میوه فروشی" , "کتابخانه" , "صحافی" , "پیست اسکی" , "پیست رالی" , "نمایشگاه ماشین" , "کنسرت" , "آشپزخانه" , "دادگاه" , "نیروگاه" , "کارخانه")
        var LOCATION = locations[Random.nextInt(0, 1000) % locations.size]
        fun createLocations(){
            LOCATION = locations[Random.nextInt(0, 1000) % locations.size]
        }
    }


    override fun onStart() {
        super.onStart()
        createLocations()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reveal)
        playerList.clear()



        intent.extras?.let {
            citizenCounter = it.getInt("citiC")
            spyCounter = it.getInt("spyC")
            timeRemaining = it.getInt("time")
        }

        var i = 0
        while (i != citizenCounter) {
            i++
            playerList.add(Citizen(PlayerType.CITIZEN, 0))
        }
        i = 0
        while (i != spyCounter) {
            playerList.add(Spy(PlayerType.SPY, 0))
            i++
        }

        playerList.shuffle()

        i = 0
        findViewById<Button>(R.id.reveal).setOnClickListener {
            findViewById<TextView>(R.id.playerNum).text = "بازیکن شماره ${i + 1}"
            if (!isShowing) {
                findViewById<ImageView>(R.id.imageView3).setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.img_show
                    )
                )

                if (playerList[i].type == PlayerType.SPY) {
                    var spyText = ""
                    playerList.forEachIndexed { index, player ->
                        if (player.type == PlayerType.SPY && i != index)
                            spyText += "\nبازیکن شماره ${index + 1} هم جاسوس است"
                    }
                    findViewById<TextView>(R.id.txtRole).text = "شما جاسوس هستید $spyText"
                    findViewById<TextView>(R.id.txtLocation).text = "ناشناخته"
                } else {
                    findViewById<TextView>(R.id.txtRole).text = "شهروند"
                    findViewById<TextView>(R.id.txtLocation).text = LOCATION
                }
                isShowing = true
            } else {
                findViewById<ImageView>(R.id.imageView3).setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.img_hidden
                    )
                )
                findViewById<TextView>(R.id.txtRole).text = "------------"
                findViewById<TextView>(R.id.txtLocation).text = "------------"
                isShowing = false
                findViewById<Button>(R.id.reveal).text = "نمایش"
            }
            findViewById<Button>(R.id.reveal).isInvisible = true
            findViewById<ConstraintLayout>(R.id.constraintLayout).setBackgroundResource(R.drawable.shape_playerbackground8)
        }

        findViewById<Button>(R.id.next).setOnClickListener {
            isShowing = false
            i++
            findViewById<TextView>(R.id.playerNum).text = "بازیکن شماره ${i + 1}"
            findViewById<TextView>(R.id.txtRole).text = "------------"
            findViewById<TextView>(R.id.txtLocation).text = "------------"
            findViewById<Button>(R.id.reveal).text = "نمایش"
            findViewById<ImageView>(R.id.imageView3).setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.img_hidden
                )
            )

            findViewById<Button>(R.id.reveal).isInvisible = false
            findViewById<ConstraintLayout>(R.id.constraintLayout).setBackgroundResource(R.drawable.shape_playerbackground3)
            if (i+1 == playerList.size) {
                (it as Button).text = "شروع"
            }
            if (i == playerList.size) {
                startActivity(Intent(this, TimerActivity::class.java).apply {
                    putExtra("timer", timeRemaining)
                })
                this.finish()
            }
        }


    }
}