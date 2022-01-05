package com.example.spygame

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class ViewPagerAdapter(
    private val onEndClick:() ->Unit
) : RecyclerView.Adapter<PagerVH>() {

    //array of colors to change the background color of screen


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {

        return PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))

    }


    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {



        if(position == 0) {
            holder.tvAbout.text = ""
            holder.ivImage.setImageResource(R.drawable.hiddenplace)
            holder.container.setBackgroundResource(R.drawable.bghalf)
            holder.card.isVisible = false
            holder.bstart.isVisible = false
            holder.card2.isVisible = false
            holder.dot.setImageResource(R.drawable.dot11)
            holder.dot.isVisible = false
        }
        if(position == 1) {
            holder.tvAbout.text = "ابتدا در این قسمت تعداد شهروندان بازی را مشخص کنید."
            holder.ivImage.setImageResource(R.drawable.fp1)
            holder.container.setBackgroundResource(R.drawable.bgcad)
            holder.card.isVisible = true
            holder.bstart.isVisible = false
            holder.card2.isVisible = true
            holder.dot.setImageResource(R.drawable.dot22)
            holder.dot.isVisible = true
        }
        if(position == 2) {
            holder.tvAbout.text = "در این قسمت شما می توانید تعداد جاسوسان بازی را مشخص کنید."
            holder.ivImage.setImageResource(R.drawable.fp2)
            holder.container.setBackgroundResource(R.drawable.bgcad)
            holder.card.isVisible = true
            holder.bstart.isVisible = false
            holder.card2.isVisible = true
            holder.dot.setImageResource(R.drawable.dot33)
            holder.dot.isVisible = true
        }
        if(position == 3) {
            holder.tvAbout.text = "سپس زمان بازی را مشخص کرده و بازی را شروع کنید."
            holder.ivImage.setImageResource(R.drawable.fp3)
            holder.container.setBackgroundResource(R.drawable.bgcad)
            holder.card.isVisible = true
            holder.bstart.isVisible = false
            holder.card2.isVisible = true
            holder.dot.setImageResource(R.drawable.dot44)
            holder.dot.isVisible = true
        }
        if(position == 4) {
            holder.tvAbout.text = "اکنون هر بازیکن گزینه نمایش را می زند، نقش خود و مکان بازی را نگاه کرده و بعد از زدن گزینه بعدی گوشی را به بازیکن بعدی می دهد."
            holder.ivImage.setImageResource(R.drawable.fp4)
            holder.container.setBackgroundResource(R.drawable.bgcad)
            holder.card.isVisible = true
            holder.bstart.isVisible = false
            holder.card2.isVisible = true
            holder.dot.setImageResource(R.drawable.dot55)
            holder.dot.isVisible = true
        }
        if(position == 5) {
            holder.tvAbout.text = "پس از اینکه همه بازیکنان از نقش خود با خبر شدن، دکمه شروع را زده تا زمان بازی آغاز شود."
            holder.ivImage.setImageResource(R.drawable.fp5)
            holder.container.setBackgroundResource(R.drawable.bgcad)
            holder.card.isVisible = true
            holder.bstart.isVisible = false
            holder.card2.isVisible = true
            holder.dot.setImageResource(R.drawable.dot66)
            holder.dot.isVisible = true
        }
        if(position == 6) {
            holder.tvAbout.text = "اکنون می توانید شروع به پرسیدن سوالات خود کنید و به بازی کردن بپردازید."
            holder.ivImage.setImageResource(R.drawable.fp6)
            holder.container.setBackgroundResource(R.drawable.bgcad)
            holder.card.isVisible = true
            holder.bstart.isVisible = true
            holder.card2.isVisible = true
            holder.dot.setImageResource(R.drawable.dot77)
            holder.dot.isVisible = true

            holder.bstart.setOnClickListener {
                onEndClick.invoke()
            }
        }
    }
}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView){
    var tvAbout = itemView.findViewById<TextView>(R.id.tvAbout)
    var ivImage = itemView.findViewById<ImageView>(R.id.ivImage)
    var bstart  = itemView.findViewById<Button>(R.id.etmam)
    var container = itemView.findViewById<ConstraintLayout>(R.id.container)
    var card = itemView.findViewById<CardView>(R.id.cardView)
    var card2 = itemView.findViewById<CardView>(R.id.cardView2)
    var dot = itemView.findViewById<ImageView>(R.id.dots)
}