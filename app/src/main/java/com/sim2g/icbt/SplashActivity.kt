package com.sim2g.icbt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.sim2g.icbt.extensions.goToActivty

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeFullScreen()

        setContentView(R.layout.activity_splash)

        // using a handle to delay loading the Login activity
        Handler().postDelayed({
            // start Activity
            this.goToActivty(this, MainActivity::class.java)

            // animate the loading of the new activity
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            // close this activity
            finish()
        }, 2000)
    }

    private fun makeFullScreen() {
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        //make full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // hide the toolbar
        supportActionBar?.hide()
    }
}