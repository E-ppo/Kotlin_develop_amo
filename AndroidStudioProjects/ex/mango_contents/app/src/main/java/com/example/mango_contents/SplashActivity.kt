package com.example.mango_contents

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.logging.Handler as Handler1

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth


        if(auth.currentUser?.uid==null){
            //회원가입이 필요. JoinActivity
            Handler().postDelayed({
                startActivity(Intent(this,JoinActivity::class.java))
                finish()
            },3000)
        }else{
            //회원가입이 되어있으므로 MainActivity
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            },3000)
        }

    }
}