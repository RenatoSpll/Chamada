package com.renatomacedo.chamada

class Aluno {
    var matricula: Int = 1
    var nome: String = ""
    var turma: String = ""

    constructor(matricula: Int, nome: String, Turma: String) {
        this.matricula = matricula
        this.nome = nome
        this.turma = Turma
    }

    constructor(){
    }


}