package com.renatomacedo.chamada

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new2.*

class NewActivity2: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new2)
        var db = DatabaseHelper(this)
        var aluno1: Aluno = Aluno(12,"Renato","MR01")
        db.addAluno(aluno1)


            var infodobanco =db.read()
            //txtAluno.text = infodobanco.get(0).nome

        for(i in 0..infodobanco.size-1){
                txtAluno.append(infodobanco.get(i).matricula.toString()+" "+infodobanco.get(i).nome+" "+infodobanco.get(i).turma+"\n")
            }

    }
}