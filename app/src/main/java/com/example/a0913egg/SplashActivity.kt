package com.example.a0913egg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000
    var auth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()
        var currentUser = auth?.currentUser

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            //이미 로그인한적이 있는지 확인합니다.
            if (currentUser == null) {

                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        val intent: Intent = Intent(applicationContext, SigninActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }, 1000)

            }else {

                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        val intent: Intent = Intent(applicationContext, NaviActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }, 1000)
            }
            startActivity(Intent(this, SigninActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}