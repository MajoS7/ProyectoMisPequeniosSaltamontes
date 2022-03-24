package com.majos7.proyectonotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterStudent : AppCompatActivity() {
    var documentfield: EditText?=null
    var namefield:EditText?=null
    var agefield:EditText?=null
    var addressfield:EditText?=null
    var phonefield:EditText?=null

    var suject1field:EditText?=null
    var suject2field:EditText?=null
    var suject3field:EditText?=null
    var suject4field:EditText?=null
    var suject5field:EditText?=null

    var grade1field:EditText?=null
    var grade2field:EditText?=null
    var grade3field:EditText?=null
    var grade4field:EditText?=null
    var grade5field:EditText?=null

    var operations:Operations?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_student)
        captureData()
    }

    private fun captureData(){
        operations= Operations()

        documentfield =findViewById(R.id.txt_document)
        namefield =findViewById(R.id.txt_name)
        agefield =findViewById(R.id.txt_age)
        addressfield =findViewById(R.id.txt_address)
        phonefield =findViewById(R.id.txt_phone)
        suject1field =findViewById(R.id.subject1)
        suject2field =findViewById(R.id.subject2)
        suject3field =findViewById(R.id.subjet3)
        suject4field =findViewById(R.id.subjet4)
        suject5field =findViewById(R.id.subjet5)
        grade1field =findViewById(R.id.grade1)
        grade2field =findViewById(R.id.grade2)
        grade3field =findViewById(R.id.grade3)
        grade4field =findViewById(R.id.grade4)
        grade5field =findViewById(R.id.grade5)

        val btnAverage:Button=findViewById(R.id.btnAverage)
        btnAverage.setOnClickListener{studentRegister()}

    }

    private fun studentRegister(){
        var DS:DataStudent=DataStudent()

       if(documentfield?.text.toString()=="" || namefield?.text.toString()=="" || agefield?.text.toString()=="" || addressfield?.text.toString()=="" || phonefield?.text.toString()=="" || suject1field?.text.toString()=="" || suject2field?.text.toString()=="" || suject3field?.text.toString()=="" || suject4field?.text.toString()=="" || suject5field?.text.toString()=="" || grade1field?.text.toString()=="" || grade2field?.text.toString()=="" || grade3field?.text.toString()=="" || grade4field?.text.toString()=="" || grade5field?.text.toString()=="" ){
            Toast.makeText(this,"Por favor rellene todos los campos",Toast.LENGTH_LONG).show()
       }
        else{
           DS.document = documentfield?.text.toString()
           DS.name = namefield?.text.toString()
           DS.age = agefield?.text.toString().toInt()
           DS.address = addressfield?.text.toString()
           DS.phone = phonefield?.text.toString()
           DS.subject1 = suject1field?.text.toString()
           DS.subject2 = suject2field?.text.toString()
           DS.subject3 = suject3field?.text.toString()
           DS.subject4 = suject4field?.text.toString()
           DS.subject5 = suject5field?.text.toString()
           DS.grade1 = grade1field?.text.toString().toDouble()
           DS.grade2 = grade2field?.text.toString().toDouble()
           DS.grade3 = grade3field?.text.toString().toDouble()
           DS.grade4 = grade4field?.text.toString().toDouble()
           DS.grade5 = grade5field?.text.toString().toDouble()
           DS.average = operations!!.calculateAverage(DS)
           DS.status=operations!!.statusStudent(DS)

           if (operations?.validatorgrades(DS)===true){
               operations?.registerStudents(DS)
               sendObjectActivity(DS)
           }
           else{
               Toast.makeText(this, "Por favor solo ingrese numeros del 0 al 5", Toast.LENGTH_SHORT).show()
           }
       }
    }

    private fun sendObjectActivity(DS:DataStudent){
        val intent= Intent(this,InformationStudent::class.java)
        val miBundle:Bundle= Bundle()
        miBundle.putString("name",DS.name)
        miBundle.putString("suject1",DS.subject1)
        miBundle.putString("suject2",DS.subject2)
        miBundle.putString("suject3",DS.subject3)
        miBundle.putString("suject4",DS.subject4)
        miBundle.putString("suject5",DS.subject5)
        miBundle.putDouble("grade1",DS.grade1)
        miBundle.putDouble("grade2",DS.grade2)
        miBundle.putDouble("grade3",DS.grade3)
        miBundle.putDouble("grade4",DS.grade4)
        miBundle.putDouble("grade5",DS.grade5)
        miBundle.putDouble("average",DS.average)
        miBundle.putString("statusStudent",DS.status)
        intent.putExtras(miBundle)
        startActivity(intent)

    }
}






