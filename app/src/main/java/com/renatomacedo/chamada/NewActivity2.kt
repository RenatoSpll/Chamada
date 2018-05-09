package com.renatomacedo.chamada

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_new2.*
import kotlinx.android.synthetic.main.linha_aluno.*
//var selecionados = arrayOfNulls<String>(15)
class NewActivity2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new2)
        var db = DatabaseHelper(this)

        var turmarecebida = intent.getStringExtra("turma")

        var infodobanco =db.readAlunos("ALUNO",turmarecebida)
        val listadealunos = findViewById<ListView>(R.id.listViewAlunos)
        listadealunos.adapter = CustomAdapter(infodobanco,this)
/*
        btnSalvar.setOnClickListener(){
            for (i: Int in 0..selecionados.size){
                if(selecionados[i]!=null){
                    db.adicionarfalta(selecionados[i].toString())
                }
            }
        }
*/

    }

    private class CustomAdapter(plistadealunos:MutableList<Aluno>, context:Context): BaseAdapter(){
        var listadealunos = plistadealunos
        private val mContext: Context

        init{
            this.mContext = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)

            val linhaaluno = layoutInflater.inflate(R.layout.linha_aluno,parent,false)
            val textNome = linhaaluno.findViewById<TextView>(R.id.textNomeDoAluno)
            textNome.setText(listadealunos.get(position).nome)

            val textMatricula = linhaaluno.findViewById<TextView>(R.id.txtMatricula)
            textMatricula.setText(listadealunos.get(position).matricula.toString())






            return linhaaluno
        }

        override fun getItem(position: Int): Any {
            return listadealunos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listadealunos.size
        }

    }

}