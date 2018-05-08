package com.renatomacedo.chamada

import android.os.Parcel
import android.os.Parcelable

class Professor() {

    var matricula: Int = 1
    var nome: String = ""
    var disciplina: String = ""
    var senha: String = ""

    constructor(matricula:Int, nome: String, disciplina: String, senha: String) : this() {
        this.matricula = matricula
        this.nome = nome
        this.disciplina = disciplina
        this.senha = senha
    }




}