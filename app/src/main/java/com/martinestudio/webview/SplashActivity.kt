package com.martinestudio.webview

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.HorizontalScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class SplashActivity : AppCompatActivity() {

    private lateinit var scrollViewFoodDelivery: HorizontalScrollView
    private lateinit var scrollViewBanking: HorizontalScrollView
    private val handler = Handler(Looper.getMainLooper())
    private val scrollSteps = 5 // The amount to scroll each step
    private val delayMillis: Long = 8
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       window.setFlags(
           WindowManager.LayoutParams.FLAG_FULLSCREEN,
           WindowManager.LayoutParams.FLAG_FULLSCREEN
       )

        Handler().postDelayed({
         val i = Intent(this@SplashActivity,MainActivity::class.java)
            startActivity(i)

            finish()
        },3000)

        var scrollVariable = findViewById<HorizontalScrollView>(R.id.splashScrollView)

        startScroll(scrollVariable)
    }

    private fun startScroll(scrollVariable: HorizontalScrollView) {
        val runnable = object:Runnable{
            override fun run() {
                val scrollX = scrollVariable.scrollX
                val maxScrollX =  scrollVariable.getChildAt(0).measuredWidth/2

                if(scrollX >=maxScrollX){
                    scrollVariable.scrollTo(0,0)
                }
                else{
                    scrollVariable.scrollTo(scrollX+scrollSteps,0)
                }
                handler.postDelayed(this,delayMillis)
            }

        }
        handler.post(runnable)

    }
}

