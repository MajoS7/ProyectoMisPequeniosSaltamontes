package com.majos7.proyectonotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAverage:Button =findViewById(R.id.btnAverageStudent)
        val btnStatistics:Button=findViewById(R.id.btnStatistics)
        val btnHelp:Button=findViewById(R.id.btnHelp)

        btnAverage.setOnClickListener{onclick(1)}
        btnStatistics.setOnClickListener{onclick(2)}
        btnHelp.setOnClickListener{onclick(3)}
    }

    private fun onclick(boton:Int){
        when (boton){
            1->{
                val intent=Intent(this,RegisterStudent::class.java)
                startActivity(intent)
            }
            2->{
                val intent=Intent(this,StudentStatistics::class.java)
                startActivity(intent)
            }
            3->{
                val intent=Intent(this,Help::class.java)
                startActivity(intent)
            }
        }

    }


}