package com.example.spygame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.spygame.databinding.ActivityMainBinding
import com.example.spygame.databinding.ActivityWalktroughBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class Walkthrough : AppCompatActivity() {
    val walktrough_key = "WALKTHROUGH"
    lateinit var binding: ActivityWalktroughBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalktroughBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ViewPagerAdapter {
            val prefs = applicationContext.getSharedPreferences(walktrough_key,Context.MODE_PRIVATE)
            val prefEditor = prefs.edit()
            prefEditor.putBoolean("has_passed",true)
            prefEditor.apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.viewPager2.adapter = adapter
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }
}