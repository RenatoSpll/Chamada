package com.renatomacedo.chamada

class Turma {

    var idTurma = 1
    var Nome = ""
    var Professor = ""
    var Horario = ""


    constructor(idTurma: Int, Nome: String, Professor: String, Horario: String) {
        this.idTurma = idTurma
        this.Nome = Nome
        this.Professor = Professor
        this.Horario = Horario
    }

    constructor(){
    }
}