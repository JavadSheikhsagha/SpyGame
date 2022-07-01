package com.example.spygame


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameinfo)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            findViewById<TextView>(R.id.textView6).text = Html.fromHtml("<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>1. ابتدا تعداد افراد شرکت کننده در بازی را انتخاب کنید</span><span dir=\"LTR\" style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>&nbsp;&nbsp;</span><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>که شامل چند شهروند و یک یا چند جاسوس است.<br>2. سپس زمان بازی را تنظیم کنید.<br> 3. دکمه <strong>شروع</strong> را زده و با باز شدن صفحه بعدی، تلفن همراه را به ترتیب به همه بازیکنان بدهید.<br> 4. در صفحه مقابل هر بازیکن، شماره بازیکن نوشته شده و در زیر آن، کادری که حاوی اطلاعات بازی است قرار دارد که با انتخاب دکمه <strong>نمایش</strong> محتوای آن مشخص می شود.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>5. در این قسمت دو حالت وجود دارد :</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span dir=\"LTR\" style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>-</span><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>&nbsp;در حالت اول نقش <strong>شهروند</strong> است که در این حالت در بخش مکان حتما نام یک مکان آمده است(تمام شهروندان نام مکان یکسانی را می بینند).</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span dir=\"LTR\" style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>-</span><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>&nbsp;در حالت دوم نقش <strong>جاسوس</strong> است که در ادامه شماره ی دیگر جاسوسان بازی آمده است. در این حالت مکان <strong>ناشناخته</strong> است.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>6. هر بازیکن بعد از دیدن اطلاعات کادر، باید روی دکمه <strong>بعدی</strong> زده و تلفن را به نفر بعدی بدهد.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>7. زمانی که تمام بازیکنان کادر مربوط به خود را دیدند باید دکمه <strong>شروع</strong> زده شده و زمان بازی آغاز شود.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><strong><span style='font-size:32px;line-height:107%;font-family:\"Arial\",sans-serif;'>روش بازی:&nbsp;</span></strong></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>در این قسمت زمان بازی آغاز می شود.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>بازیکنان با پرسیدن سوالاتی درباره مکان مورد نظر، سعی در شناسایی جاسوس یا جاسوسان می کنند.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>سوالات باید به صورت &quot;<strong>این</strong> یا <strong>آن&quot;</strong> و یا &quot;<strong>بله</strong> یا <strong>خیر&quot;</strong> باشد.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>با توجه به جواب سوالات اگر بازیکنان به کسی شک داشتند، باید با رای گیری سعی در حذف بازیکن از بازی کنند.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>اگر رای اکثریت به حذف آن بازیکن باشد آن بازیکن حذف می شود. حال دو حالت رخ می دهد:</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>&nbsp; &nbsp;اگر بازیکن شهروند بود بازی به نفع جاسوسان به پایان می رسد</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>&nbsp; &nbsp;اگر بازیکن جاسوس بود از او می خواهیم که مکان را حدس بزند. اگر جواب &quot;<strong>صحیح&quot;</strong> بود، بازی به نفع جاسوسان به پایان می رسد.اگر جواب &quot;<strong>غلط</strong>&quot; بود، بازی ادامه پیدا می کند.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>اگر شهروندان قبل از اتمام زمان بازی موفق به شناسایی &quot;<strong>تمام&quot;</strong> جاسوسان شوند، بازی به نفع شهروندان به پایان میرسد.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>اما اگر زمان تمام شود و هنوز جاسوس یا جاسوسانی در بازی باشند، بازی به نفع جاسوسان به پایان میرسد.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>راهنما:</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>مثلا اگر مکان رستوران بود ، در سوال &quot;مداد یا چاقو؟&quot; پاسخ صحیح چاقو است.</span></p>\n" +
                    "<p dir=\"RTL\" style='margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;line-height:107%;font-size:15px;font-family:\"Calibri\",sans-serif;text-align:right;'><span style='font-size:27px;line-height:107%;font-family:\"Arial\",sans-serif;'>حال اگر بازیکن مداد را به عنوان جواب انتخاب کند، مشخص میشود که مکان را نمیداند و میتوان آن بازیکن را به عنوان جاسوس در نظر گرفته و از بازی حذف کرد.</span></p>",Html.FROM_HTML_MODE_COMPACT)
        }
        findViewById<Button>(R.id.understand).setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
    override fun onBackPressed(){
        finish()
        startActivity(Intent(this,MainActivity::class.java))
    }

}