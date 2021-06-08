package br.iesb.mobile.carwash.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import br.iesb.mobile.carwash.R

class UserRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)
        val retornarBtn = findViewById(R.id.imageView24) as ImageView
        retornarBtn.setOnClickListener {
            startActivity(
                Intent(this@UserRegisterActivity,MainActivity::class.java).apply{}
            )
        }
    }
}