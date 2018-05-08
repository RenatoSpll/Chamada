package com.renatomacedo.chamada

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import android.widget.Toast
//class DatabaseHelper(var context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int): SQLiteOpenHelper(context, name, factory, version)

val DATABASE_NAME = "Chamada"
val Tabela_Aluno = "ALUNO"
val Aluno_Matricula = "MATRICULA"
val Aluno_Nome = "NOME"
val Aluno_Turma = "TURMA"

class DatabaseHelper(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    val TabelaProfessor = "PROFESSOR"
    val ProfessorMatricula = "MATRICULA"
    val ProfessorNome = "NOME"
    val ProfessorDisciplina = "DISCIPLINA"
    val ProfessorSenha = "SENHA"

    val TabelaTurma = "TURMA"
    val TurmaidTurma = "idTurma"
    val TurmaProfessor = "PROFESSOR"
    val TurmaNome = "NOME"
    val TurmaHorario = "Horario"


    var createtableProfessor =
            "CREATE TABLE PROFESSOR(" +
                    "  MATRICULA INT PRIMARY KEY NOT NULL," +
                    "  NOME  VARCHAR(255)  NOT NULL," +
                    "  DISCIPLINA VARCHAR(255)," +
                    "  SENHA VARCHAR(255) NOT NULL);"

    var createtableTurma =
                    " CREATE TABLE TURMA(" +
                    "  idTurma INT PRIMARY KEY NOT NULL," +
                    "  PROFESSOR VARCHAR(255) NOT NULL," +
                    "  NOME VARCHAR(255) NOT NULL," +
                    "  HORARIO VARCHAR(10));"



    override fun onCreate(db: SQLiteDatabase?) {
        //var createtableAluno: String = "CREATE TABLE "+ Tabela_Aluno + "("+
              //  Aluno_Matricula +" INTEGER PRIMARY KEY NOT NULL," +
                //Aluno_Nome + " VARCHAR(256) NOT NULL,"+
                //Aluno_Turma +" VARCHAR(255) NOT NULL);"
        var createtableAluno = "Create table Aluno(MATRICULA INT PRIMARY KEY NOT NULL, NOME VARCHAR(255) NOT NULL, TURMA VARCHAR(255) NOT NULL);"
        db?.execSQL(createtableAluno)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table IF EXISTS "+ Tabela_Aluno)
        onCreate(db)

    }


    fun addProfessor(matricula: Int, nome:String,senha: String, disciplina: String){
        var values: ContentValues = ContentValues()

        values.put(ProfessorMatricula,matricula)
        values.put(ProfessorNome,nome)
        values.put(ProfessorSenha, senha)
        values.put(ProfessorDisciplina, disciplina)

        var result = this.writableDatabase.insert(TabelaProfessor, null, values)
        if(result == -1.toLong())
            Toast.makeText(context,"Falha",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Adicionado",Toast.LENGTH_SHORT).show()
    }

    fun addTurma(idTurma: Int, professor: Int, nome: String, horario: String){
        var values: ContentValues = ContentValues()
        values.put(TurmaidTurma,idTurma)
        values.put(TurmaProfessor, professor)
        values.put(TurmaNome, nome)
        values.put(TurmaHorario, horario)

        var result = this.writableDatabase.insert(TabelaTurma, null, values)
        if(result == -1.toLong())
            Toast.makeText(context,"Falha",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Adicionado",Toast.LENGTH_SHORT).show()
    }


    fun addAluno(aluno: Aluno){
        var values: ContentValues = ContentValues()
        values.put(Aluno_Matricula, aluno.matricula)
        values.put(Aluno_Nome,aluno.nome)
        values.put(Aluno_Turma, aluno.turma)
/*
        var result = this.writableDatabase.insert(Tabela_Aluno, null, values)
        if(result == -1.toLong())
            Toast.makeText(context,"Falha",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Adicionado",Toast.LENGTH_SHORT).show()
  */
    }

    fun delete(matricula: Int,NomeTabela:String){

        var result = this.writableDatabase.delete(NomeTabela,"matricula = ?", arrayOf(matricula.toString()))
/*
        if(result == -1)
            Toast.makeText(context,"Falha",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Excluido",Toast.LENGTH_SHORT).show()
        this.writableDatabase.close()
  */
    }

    fun read(): MutableList<Aluno>{
        var list: MutableList<Aluno> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from " + Tabela_Aluno
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var aluno = Aluno()
                aluno.matricula = result.getString(0).toInt()
                aluno.nome = result.getString(1)
                aluno.turma = result.getString(2)
                list.add(aluno)
            }while (result.moveToNext())
        }

        result.close()
        //db.close()
        return list
    }
}