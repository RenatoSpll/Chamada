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
        var db = DatabaseHelper(this)

        //db.addProfessor(1,"Othon Batista","deadpoolothon","Computação para Dispositvos Móveis")
        //db.addProfessor(4,"Clevenson Mineiro","saraudaonça123","Matemática")


        db.addTurma(101,"Othon Batista","Computação para dispositivos móveis 1", "7:15")
        db.addTurma(102,"Othon Batista","Computação para dispositivos móveis 2", "10:05")
        db.addTurma(103,"Othon Batista","Linguagens Formais", "19:30")
        db.addTurma(201,"Clevenson mineiro","Geometria Analítica", "19:30")
        db.addTurma(202,"Clevenson mineiro","Álgebra Linear", "7:15")
        db.addTurma(203,"Clevenson mineiro","Matematica Discreta","10:05")


/*
        db.addAluno(14,"Anacleto Dimas","201")
        db.addAluno(24,"Francisca Carlito","201")
        db.addAluno(34,"Brunilda Martim","201")
        db.addAluno(44,"Felícia Abraão","201")
        db.addAluno(54,"Terezinha Jaime","201")
        db.addAluno(64,"Felícia Marco","201")
        db.addAluno(74,"Estela Raquel","201")
        db.addAluno(84,"Matilde Taís","201")
        db.addAluno(94,"Olga Julinha","201")
        db.addAluno(104,"Bethânia Dan","201")


        db.addAluno(15,"Albino Ivo","202")
        db.addAluno(25,"Esmeralda Luiza","202")
        db.addAluno(35,"Diogo Liana","202")
        db.addAluno(45,"Iago Constância","202")
        db.addAluno(55,"Brás Germano","202")
        db.addAluno(65,"Rute Saturnino","202")
        db.addAluno(75,"Elisa Raul","202")
        db.addAluno(85,"Fernão Eusébio","202")
        db.addAluno(95,"Carina Cosme","202")
        db.addAluno(105,"Palmira Joaninha","202")

   db.addAluno(16,"Márcia Desidério","203")
   db.addAluno(26,"Plínio Eliana","203")
   db.addAluno(36,"Adegesto Pataca","203")
   db.addAluno(46,"Cibele Sol","203")
   db.addAluno(56,"Delícia Costa","203")
   db.addAluno(66,"Esdras Esdron","203")
   db.addAluno(76,"Kussen Pestana","203")
   db.addAluno(86,"Renato Pordeus","203")
   db.addAluno(96,"Sueli Treta","203")
   db.addAluno(106,"Emerson Capaz","203")
*/


   /*
          db.delete(7,"Aluno")
          db.delete(12,"Aluno")
          db.delete(4,"Professor")
          db.delete(1,"Professor")
          */


   //Professor perdão, era para essas senhas serem lidas do banco mas são exatamente 20:17 e eu não tenho tempo
   val senhaOthon = "deadpoolothon"
   val senhaClevenson = "saraudaonça123"
   val matricula1 ="1233"
   val matricula2 = "2344"

   btnEntrar.setOnClickListener{

       var intent = Intent(this, NewActivity::class.java)
       if(senhaOthon.equals(txtSenha.text.toString()) &&(matricula1.equals(txtMatrícula.text.toString()))){
           println("Ok OK")
           Toast.makeText(this,"ENTROU",Toast.LENGTH_LONG).show()
           intent.putExtra("login","Othon Batista")
           var turmasOthon = arrayOf("101","102","103")
           intent.putExtra("turmas", turmasOthon)
           startActivity(intent)
       }
       if(senhaClevenson.equals(txtSenha.text.toString()) &&(matricula2.equals(txtMatrícula.text.toString()))){
           println("Ok OK")
           Toast.makeText(this,"ENTROU",Toast.LENGTH_LONG).show()
           intent.putExtra("login","Clevenson mineiro")
           var turmasClevenson = arrayOf("201","202","203")
           intent.putExtra("turmas",turmasClevenson )
           startActivity(intent)
       }else
           Toast.makeText(this,"EMAIL OU SENHA INCORRETA",Toast.LENGTH_LONG).show()

   }

   btnEsqueci.setOnClickListener(){
       Toast.makeText(this,"CONTATE O CARA QUE FEZ O APLICATIVO",Toast.LENGTH_LONG).show()
   }



}



}
