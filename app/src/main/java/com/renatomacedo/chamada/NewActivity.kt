package com.renatomacedo.chamada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*


class NewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        var db = DatabaseHelper(this)


        txtProfessor.text = intent.getStringExtra("login")
        var turmas = intent.getStringArrayExtra("turmas")


      // var turma = db.readTurma(intent.getStringExtra("login"))
/*
        btnPrimeiraTurma.text = turma.get(0).Nome
        btnSegundaTurma.text = turma.get(1).Nome
        btnTerceiraTurma.text = turma.get(2).Nome

*/

        btnPrimeiraTurma.setOnClickListener{
            val intent = Intent (this,NewActivity2::class.java)
            intent.putExtra("turma",turmas[0])


            startActivity(intent)
        }

        btnSegundaTurma.setOnClickListener{
            val intent = Intent (this,NewActivity2::class.java)
            intent.putExtra("turma",turmas[1])

            startActivity(intent)
        }

        btnTerceiraTurma.setOnClickListener{
            val intent = Intent (this,NewActivity2::class.java)
            intent.putExtra("turma",turmas[2])

            startActivity(intent)
        }


    }

}