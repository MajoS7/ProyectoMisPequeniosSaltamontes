package com.majos7.proyectonotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Help : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        val btnClose: Button =findViewById(R.id.btnClose3)
        btnClose.setOnClickListener{onclick()}
    }
    private fun onclick(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}