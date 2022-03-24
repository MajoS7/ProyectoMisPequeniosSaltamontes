package com.majos7.proyectonotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class InformationStudent : AppCompatActivity() {


    var namefield: TextView?=null

    var suject1field: TextView?=null
    var suject2field: TextView?=null
    var suject3field: TextView?=null
    var suject4field: TextView?=null
    var suject5field: TextView?=null

    var grade1field: TextView?=null
    var grade2field: TextView?=null
    var grade3field: TextView?=null
    var grade4field: TextView?=null
    var grade5field: TextView?=null
    var averagefield: TextView?=null
    var statusfield: TextView?=null

    var operations:Operations?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_student)
        captureData()

    }
    private fun captureData(){
        operations= Operations()

        namefield =findViewById(R.id.txtNameIE)
        suject1field =findViewById(R.id.txtSubjectIE1)
        suject2field =findViewById(R.id.txtSubjectIE2)
        suject3field =findViewById(R.id.txtSubjectIE3)
        suject4field =findViewById(R.id.txtSubjectIE4)
        suject5field =findViewById(R.id.txtSubjectIE5)
        grade1field =findViewById(R.id.txtGradeEI1)
        grade2field =findViewById(R.id.txtGradeEI2)
        grade3field =findViewById(R.id.txtGradeEI3)
        grade4field =findViewById(R.id.txtGradeEI4)
        grade5field =findViewById(R.id.txtGradeEI5)
        averagefield=findViewById(R.id.txtAverageIE)
        statusfield=findViewById(R.id.txtStatusIE)

        showData()

        val btnClose:Button=findViewById(R.id.btnClose2)
        btnClose.setOnClickListener{closewindows()}
    }

    private fun showData(){
        var miBundle:Bundle?=this.intent.extras

        if (miBundle!=null){
            namefield!!.text="${miBundle.getString("name")}"
            suject1field!!.text="${miBundle.getString("suject1")}"
            suject2field!!.text="${miBundle.getString("suject2")}"
            suject3field!!.text="${miBundle.getString("suject3")}"
            suject4field!!.text="${miBundle.getString("suject4")}"
            suject5field!!.text="${miBundle.getString("suject5")}"
            grade1field!!.text="${miBundle.getDouble("grade1")}"
            grade2field!!.text="${miBundle.getDouble("grade2")}"
            grade3field!!.text="${miBundle.getDouble("grade3")}"
            grade4field!!.text="${miBundle.getDouble("grade4")}"
            grade5field!!.text="${miBundle.getDouble("grade5")}"
            averagefield!!.text="${miBundle.getDouble("average")}"
            statusfield!!.text="${miBundle.getString("statusStudent")}"
        }

    }
    private fun closewindows(){
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}