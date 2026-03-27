package br.edu.fatecpg.letterboxdlist.model

data class Titulo(
    val nome: String,
    val genero: String,
    var isAssistido: Boolean=false,
    var nota: Double = 0.0
)