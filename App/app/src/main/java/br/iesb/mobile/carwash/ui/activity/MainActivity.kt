package br.iesb.mobile.carwash.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.iesb.mobile.carwash.R

class MainActivity : AppCompatActivity() {
    lateinit var cadatrarBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cadastroBtn = findViewById(R.id.btCadastrar) as Button
        cadastroBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, UserRegisterActivity::class.java).apply {})
        }
    }
}