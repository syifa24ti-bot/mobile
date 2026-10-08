package com.example.syifa_3tie.pertemuan_6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.syifa_3tie.MainActivity
import com.example.syifa_3tie.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Sembunyikan Action Bar di sini agar tampilan Full Screen
        supportActionBar?.hide()

        setContentView(R.layout.activity_splash_screen)

        lifecycleScope.launch {
            delay(2000) // Simulasi delay 2 detik untuk branding splash screen

            // Cek session SharedPreferences
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            // Percabangan sesuai alur poin 4
            if (isLogin) {
                // Jika isLogin true -> Arahkan ke MainActivity
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Jika isLogin false -> Arahkan ke AuthActivity
                val intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
                startActivity(intent)
            }

            finish() // Tutup SplashScreenActivity agar user tidak bisa klik tombol back balik ke sini
        }
    }
}