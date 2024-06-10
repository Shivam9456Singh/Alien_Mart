package com.martinestudio.webview

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.martinestudio.webview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)


        // Optional: Hide the action bar if present
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // Food delivery Apps
        setupImageButton(binding.btnSwiggy, SwiggyActivity::class.java, "Opening Swiggy...")
        setupImageButton(binding.btnZomato, ZomatoActivity::class.java, "Opening Zomato...")
        setupImageButton(binding.btnBlinkit, BlinkitActivity::class.java, "Opening Blinkit...")
        setupImageButton(binding.btnUberEats, UberActivity::class.java, "Opening UberEats...")

        // Payment Apps
        setupImageButton(binding.btnPaytm, PaytmActivity::class.java, "Opening Paytm...")
        setupImageButton(binding.btnPhonePay, PhonePayActivity::class.java, "Opening PhonePay...")
        setupImageButton(binding.btnGpay, GPayActivity::class.java, "Opening Google Pay...")
        setupImageButton(binding.btnBharatPay, BharatPayActivity::class.java, "Opening BharatPe...")

        // Shopping Apps
        setupImageButton(binding.btnFlipkart, FlipkartActivity::class.java, "Opening Flipkart...")
        setupImageButton(binding.btnAmazon, AmazonActivity::class.java, "Opening Amazon...")
        setupImageButton(binding.btnMyntra, MyntraActivity::class.java, "Opening Myntra...")
        setupImageButton(binding.btnMeesho, MeeshooActivity::class.java, "Opening Meesho...")

        // Entertainment Apps
        setupImageButton(binding.btnNetflix, NetflixActivity::class.java, "Opening Netflix...")
        setupImageButton(binding.btnPrimeVideo, PrimeVideoActivity::class.java, "Opening PrimeVideo...")
        setupImageButton(binding.btnHotstar, HotstarActivity::class.java, "Opening Hotstar...")
        setupImageButton(binding.btnMxplayer, MxPlayerActivity::class.java, "Opening MxPlayer...")
        setupImageButton(binding.btnYoutube, YoutubeActivity::class.java, "Opening Youtube...")
    }

    private fun setupImageButton(button: ImageView, activityClass: Class<*>, toastMessage: String) {
        button.setOnClickListener {
            startActivity(Intent(applicationContext, activityClass))
            Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
