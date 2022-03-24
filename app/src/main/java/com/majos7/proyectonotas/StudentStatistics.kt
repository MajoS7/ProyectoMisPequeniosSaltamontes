package com.majos7.proyectonotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class StudentStatistics : AppCompatActivity() {

    var registerfield: TextView?=null
    var winnersfield: TextView?=null
    var lostsfield: TextView?=null
    var recoverfield: TextView?=null
    var operations:Operations?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_statistics)
        capDate()
    }
    private fun capDate(){
        operations= Operations()

        registerfield =findViewById(R.id.txtRegister)
        winnersfield =findViewById(R.id.txtWinner)
        lostsfield =findViewById(R.id.txtLost)
        recoverfield =findViewById(R.id.txtRecover)
        val btnClose:Button=findViewById(R.id.btnClose)
        btnClose.setOnClickListener{closewindows()}

        showData()
    }
    private fun showData(){
        registerfield!!.text = operations!!.numberStudents().toString()
        winnersfield!!.text = operations!!.statusNumberStudents("Gano").toString()
        var lostsTotal:Int=operations!!.statusNumberStudents("Perdio, no tiene posibilidad de recuperar")+operations!!.statusNumberStudents("Puede Recuperar")
        lostsfield!!.text = lostsTotal.toString()
        recoverfield!!.text = operations!!.statusNumberStudents("Puede Recuperar").toString()
    }


    private fun closewindows(){
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}