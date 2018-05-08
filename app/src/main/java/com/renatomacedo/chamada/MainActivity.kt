package com.renatomacedo.chamada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import com.example.alexandre.myapplication.NewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val db = DatabaseHelper(this)
        //db.addProfessor(1,"Othon Batista","deadpoolothon","Computação para Dispositvos Móveis")
        //db.addProfessor(4,"Clevenson Mineiro","saraudaonça123","Matemática")
        //db.delete(1,"Professor")
        var aluno1: Aluno = Aluno(12,"Renato","MR01")
        var aluno2: Aluno = Aluno(20,"Jonas","MR02")
        var aluno3: Aluno = Aluno(7,"Rigeraldo","MR05")


        //db.addAluno(aluno1)
        //db.addAluno(aluno2)
        //db.addAluno(aluno3)
        //db.delete(7,"Aluno")

        btnEntrar.setOnClickListener{

            var intent = Intent(this, NewActivity::class.java)

            startActivity(intent)
        }




    }



}
