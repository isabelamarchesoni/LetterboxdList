package br.edu.fatecpg.letterboxdlist.dao
import br.edu.fatecpg.letterboxdlist.model.Titulo

interface TituloDao {
    fun adicionarTitulo(titulo: Titulo)
    fun listarTitulo(): List<Titulo>
}